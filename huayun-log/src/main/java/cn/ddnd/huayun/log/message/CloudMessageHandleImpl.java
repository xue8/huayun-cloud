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

public class CloudMessageHandleImpl implements MessageHandle {

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
        try {
            List<List<Object>> lists1 = (List<List<Object>>) cloud.getData();
        } catch (Exception e) {
            return null;
        }
        List<List<Object>> lists = (List<List<Object>>) cloud.getData();
        if (lists.size() == 0 || lists == null)
            return null;
        try {
            lists.get(0);
        } catch (Exception e) {
            return null;
        }
        String datetime = (String) lists.get(0).get(0);
        Double used = Double.valueOf(lists.get(0).get(1).toString());

        Map map = new HashMap();
        map.put("index", "cloud");
        map.put("username", "xue8");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            Date date = format.parse(datetime);
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            datetime = format1.format(date.getTime() + 28800000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        map.put("datetime", datetime);
        map.put("used",  used);
        map.put("type", typeName);
        map.put("id", id);
        map.put("unit", cloud.getUnit());
        map.put("interval", cloud.getInterval());
        return map;
    }


}
