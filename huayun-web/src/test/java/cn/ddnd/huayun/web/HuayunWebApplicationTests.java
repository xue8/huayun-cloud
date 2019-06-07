package cn.ddnd.huayun.web;

import cn.ddnd.huayun.es.service.SearchService;
import cn.ddnd.huayun.web.msm.AliyunSms;
import cn.ddnd.huayun.web.msm.EmailSender;
import cn.ddnd.huayun.web.pojo.CloudInfo;
import cn.ddnd.huayun.web.pojo.MonitorInfo;
import cn.ddnd.huayun.web.pojo.MonitorRequest;
import cn.ddnd.huayun.web.scheduled.MonitorScheduled;
import cn.ddnd.huayun.web.service.*;
import cn.ddnd.huayun.web.service.impl.CloudManageServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
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
    MonitorRequest request1;
    @Autowired
    MonitorRequest request2;
    @Autowired
    MonitorRequest request3;
    @Reference
    SearchService searchService;
    @Autowired
    MonitorScheduled monitorScheduled;
    @Autowired
    AliyunSms aliyunSms;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    MonitorRecordService monitorRecordService;
    @Autowired
    MonitorInfoService monitorInfoService;
    @Autowired
    CloudSnapshotService snapshotService;
    @Autowired
    RouterService routerService;

    @Test
    public void contextLoads() {
//        String str = "【华云比赛】尊敬的用户，您的云服务器Id：${cloudId}, 资源${type}，使用率超过${used}，请及时处理！";
//        aliyunSms.send("18589831291", str);

        List list2 = routerService.queryRouter("36c34ff3094b4dec9786dcc35d1f0d41",
                "b87e24ad3b00420fadec14a9260ca94e",
                "cn-chengdu", "");

        List list1 = routerService.routerInMonitor("36c34ff3094b4dec9786dcc35d1f0d41",
                "b87e24ad3b00420fadec14a9260ca94e",
                "cn-chengdu", "r-sk7yj56lsa186", "2019-06-06 21:28:10", "2019-06-06 22:28:10");
        System.out.println();
//        List<MonitorInfo> infoByTime = monitorInfoService.findMonitorInfoByTime(60);
//        snapshotService.queryCloudSnapshot("36c34ff3094b4dec9786dcc35d1f0d41",
//                "b87e24ad3b00420fadec14a9260ca94e",
//                "cn-huaian", "", "");
//
//        monitorInfoService.findMonitorInfoByUsername("xue8");
//
//        monitorInfoService.deleteMonitorInfoById("5");
//        redisTemplate.delete("*");
////        service.queryCloudStatus("36c34ff3094b4dec9786dcc35d1f0d41", "b87e24ad3b00420fadec14a9260ca94e");
////
////        List<CloudInfo> search = searchService.search("cloud_cpu", "_doc", "xue8", "i-zz6rj39kty724",
////                "2019-06-06T14:14:00", "2019-06-06T15:14:00", false);
//
//        System.out.println();
    }


}
