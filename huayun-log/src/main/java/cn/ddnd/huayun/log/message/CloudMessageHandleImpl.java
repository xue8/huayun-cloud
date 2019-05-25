package cn.ddnd.huayun.log.message;

import cn.ddnd.huayun.log.pojo.Cloud;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: huayun
 * @description: 数据格式化
 * @author: Xue 8
 * @create: 2019-05-21 17:45
 **/

public class CloudMessageHandleImpl implements MessageHandle {

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
        map.put("datetime", datetime);
        map.put("used",  used);
        map.put("type", typeName);
        map.put("id", "i-zz6rj39kty724");
        map.put("unit", cloud.getUnit());
        map.put("interval", cloud.getInterval());
        return map;
    }


}
