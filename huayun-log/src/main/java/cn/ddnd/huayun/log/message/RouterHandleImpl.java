package cn.ddnd.huayun.log.message;

import cn.ddnd.huayun.log.pojo.Cloud;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouterHandleImpl implements MessageHandle{

    /**
     * 解析数据
     * @param msg
     * @param typeName
     * @return
     */
    @Override
    public Map handle(String msg, String typeName, String id) {
        JSONObject jsonObject = JSONObject.parseObject(msg);
        Cloud cloud = JSON.toJavaObject(jsonObject, Cloud.class);

        if (cloud.getData() == null)
            return null;
        List list = null;
        try {
            list = (List) cloud.getData();
        } catch (ClassCastException e) {
            return null;
        }
        if (list == null || list.size() == 0)
            return null;
        List list1 = (List) list.get(0);
        String datetime = (String) list1.get(0);
        Double used = Double.valueOf(String.valueOf(list1.get(1)));

        Map map1 = new HashMap();
        map1.put("index", "router");
        map1.put("username", "xue8");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            Date date = format.parse(datetime);
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            datetime = format1.format(date.getTime() + 28800000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        map1.put("datetime", datetime);
        map1.put("used",  used);
        map1.put("type", typeName);
        map1.put("id", id);
        map1.put("unit", cloud.getUnit());
        map1.put("interval", cloud.getInterval());
        return map1;
    }
}
