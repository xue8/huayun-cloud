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
    public Map handle(String msg, String typeName) {
        JSONObject jsonObject = JSONObject.parseObject(msg);
        Cloud cloud = JSON.toJavaObject(jsonObject, Cloud.class);

        List<List<Object>> lists = (List<List<Object>>) cloud.getData();
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
        map.put("id", "i-zz6rj39kty724");
        map.put("unit", cloud.getUnit());
        map.put("interval", cloud.getInterval());
        return map;
    }


}
