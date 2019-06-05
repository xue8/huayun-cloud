package cn.ddnd.huayun.web;

import cn.ddnd.huayun.es.service.SearchService;
import cn.ddnd.huayun.web.ioc.ApplicationUtil;
import cn.ddnd.huayun.web.mail.EmailSender;
import cn.ddnd.huayun.web.mapper.MonitorInfoMapper;
import cn.ddnd.huayun.web.pojo.CloudInfo;
import cn.ddnd.huayun.web.pojo.MonitorInfo;
import cn.ddnd.huayun.web.pojo.MonitorRequest;
import cn.ddnd.huayun.web.scheduled.MonitorScheduled;
import cn.ddnd.huayun.web.service.CheckIdentityService;
import cn.ddnd.huayun.web.service.CloudManageService;
import cn.ddnd.huayun.web.service.CloudService;
import cn.ddnd.huayun.web.service.impl.CloudManageServiceImpl;
import cn.ddnd.huayun.web.service.impl.monitor.CreateCloudMonitorServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


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
    @Autowired
    CreateCloudMonitorServiceImpl createCloudMonitorService;
    @Autowired
    MonitorRequest request1;
    @Autowired
    MonitorRequest request2;
    @Autowired
    MonitorRequest request3;
    @Autowired
    MonitorInfoMapper monitorInfoMapper;
    @Reference
    SearchService searchService;
    @Autowired
    MonitorScheduled monitorScheduled;

    @Test
    public void contextLoads() {

        List<CloudInfo> search = searchService.searchBystartDatetime("cloud_cpu", "_doc", "xue8", "i-zz6rj39kty724",
                "2019-06-04T05:44:00", false);
        System.out.println();
    }


}
