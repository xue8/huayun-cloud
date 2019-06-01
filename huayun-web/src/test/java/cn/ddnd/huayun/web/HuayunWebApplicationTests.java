package cn.ddnd.huayun.web;

import cn.ddnd.huayun.web.mail.EmailSender;
import cn.ddnd.huayun.web.service.CheckIdentityService;
import cn.ddnd.huayun.web.service.CloudManageService;
import cn.ddnd.huayun.web.service.CloudService;
import cn.ddnd.huayun.web.service.impl.CloudManageServiceImpl;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableDubbo
public class HuayunWebApplicationTests {

    @Autowired
    CloudService cloudService;
    @Autowired
    CloudManageService cloudManage;
    @Autowired
    CheckIdentityService checkIdentityService;
    @Autowired
    CloudManageService cloudManageService;
    @Autowired
    CloudManageServiceImpl service;
    @Autowired
    EmailSender send;

    @Test
    public void contextLoads() {
        send.send("我是标题", "message", "3788837@qq.com");
    }


}
