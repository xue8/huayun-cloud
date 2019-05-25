package cn.ddnd.huayun.log;

import cn.ddnd.huayun.log.pojo.Cloud;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: huayun
 * @description:
 * @author: Xue 8
 * @create: 2019-05-21 22:25
 **/
public class Test {
    public static void main(String[] args) {
        String msg = "\n" +
                "{\n" +
                "\"TaskId\":\"2dc2e3e81921680000016ae3d27ac825011\",\n" +
                "\"Unit\":\"Kbps\",\n" +
                "\"Interval\":60,\n" +
                "\"Data\":[\n" +
                "{\n" +
                "\"Ip\":\"103.36.192.209\",\n" +
                "\"Data\":[\n" +
                "[\n" +
                "\"2019-04-27T08:00:00Z\",\n" +
                "0\n" +
                "]\n" +
                "]\n" +
                "}\n" +
                "]\n" +
                "}\n" +
                "\n";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss +0800");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowDate = new Date();
//        String date = format.format(nowDate);
        String startTime = format1.format(nowDate.getTime() - 300000);
        String endTime = format1.format(nowDate.getTime() + 300000);
        System.out.println();
//        CloudRequestUrl url = new OkHttpRequestImpl();
//        Map map = new HashMap();
//        map.put("Action", "DescribeInstances");
//        map.put("Region", "cn-huaian");
//        map.put("Date", "2019-05-22T09:47:35 +0800");
//        map.put("AccessKeyId", "36c34ff3094b4dec9786dcc35d1f0d41");
//        map.put("Version", "1.0");
//
//        url.getRequestUrl(map);


//        String a = signature.getSignature();
//        System.out.println();

//        String a1 = signature.getSignature("Action=DescribeInstances" +
//                        "&Region=cn-huaian" +
//                        "&AccessKeyId=36c34ff3094b4dec9786dcc35d1f0d41" +
//                        "&Date=" + date1
//                "&Name=%E6%B5%8B%E8%AF%95%E6%8C%89%E9%87%8Fapi" +
//                        "&Version=1.0");
    }
}
