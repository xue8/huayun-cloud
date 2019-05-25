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
 * @create: 2019-05-23 16:53
 **/
public class CloudDiskMessageHandleImpl implements MessageHandle{

    @Override
    public Map handle(String msg, String typeName) {
        JSONObject jsonObject = JSONObject.parseObject(msg);
        Cloud cloud = JSON.toJavaObject(jsonObject, Cloud.class);

        List list = (List) cloud.getData();
        Map map = (Map) list.get(0);
        String tag = (String) map.get("Tag");
        List list1 = (List) map.get("Data");
        String dateTime = (String) ((List) list1.get(0)).get(0);
        Double used = Double.valueOf(((List) list1.get(0)).get(1).toString());

        Map map1 = new HashMap();
        map1.put("index", "cloud");
        map1.put("username", "xue8");
        map1.put("datetime", dateTime);
        map1.put("used",  used);
        map1.put("type", typeName);
        map1.put("id", "i-zz6rj39kty724");
        map1.put("tag", tag);
        map1.put("unit", cloud.getUnit());
        map1.put("interval", cloud.getInterval());
        return map1;
    }
}
