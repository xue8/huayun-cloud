package cn.ddnd.huayun.log;

import cn.ddnd.huayun.log.config.Global;
import cn.ddnd.huayun.log.request.OkHttpRequest;
import cn.ddnd.huayun.log.request.OkHttpRequestImpl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
@EnableScheduling
public class LogCollectionApplicationTests {

//    @Autowired
//    RabbitTemplate rabbitTemplate;
    @Autowired
    Global global;

    @Test
    public void contextLoads() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss +0800");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(new Date());
        String startTime = format1.format(new Date());
        String endTime = format1.format(new Date().getTime() + 300000);

        Map map = new HashMap();
        map.put("Action", "InstanceCpuMonitor");
        map.put("Region", "cn-huaian");
        map.put("Date", date);
        map.put("AccessKeyId", "36c34ff3094b4dec9786dcc35d1f0d41");
        map.put("Version", "1.0");
        map.put("Id", "i-zz6rj39kty724");
        map.put("StartTime", startTime);
        map.put("EndTime", endTime);

        OkHttpClient okHttpClient = new OkHttpClient();
        OkHttpRequest okHttpRequest = new OkHttpRequestImpl();
        Request request = okHttpRequest.getRequestUrl(map);
        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println(response.body().string());
            System.out.println("x");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
