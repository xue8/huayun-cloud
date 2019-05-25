package cn.ddnd.huayun.web;

import cn.ddnd.huayun.web.service.CheckIdentityService;
import cn.ddnd.huayun.web.service.CloudManageService;
import cn.ddnd.huayun.web.service.CloudService;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void contextLoads() {
        checkIdentityService.check("36c34ff3094b4dec9786dcc35d1f0d41", "b87e24ad3b00420fadec14a9260ca94e");
//        cloudManage.queryCloud();
    }

}
