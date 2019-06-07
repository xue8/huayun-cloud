package cn.ddnd.huayun.log;

import cn.ddnd.huayun.log.config.Global;
import cn.ddnd.huayun.log.request.OkHttpRequest;
import cn.ddnd.huayun.log.request.OkHttpRequestImpl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        rabbitTemplate.convertAndSend("test.direct", "test", "xx");
    }

}
