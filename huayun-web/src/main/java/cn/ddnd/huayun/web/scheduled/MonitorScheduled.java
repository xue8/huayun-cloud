package cn.ddnd.huayun.web.scheduled;

import cn.ddnd.huayun.es.service.SearchService;
import cn.ddnd.huayun.web.config.Global;
import cn.ddnd.huayun.web.pojo.CloudInfo;
import cn.ddnd.huayun.web.pojo.MonitorInfo;
import cn.ddnd.huayun.web.service.MonitorInfoService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MonitorScheduled {

    @Autowired
    MonitorInfoService monitorService;
    @Reference
    SearchService searchService;
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 一分钟执行一次
     */
    @Scheduled(cron = "0/60 * * * * *")
    public void oneMinutes() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = new Date();
        String var1 = format.format(date.getTime() - 60000);
        String var2 = format.format(date.getTime() - 120000);
        List<MonitorInfo> monitorInfoList = monitorService.findMonitorInfoByTime(60);
        excute(monitorInfoList, var1, var2);
        System.out.println("----------1分钟: " + monitorInfoList.size());
    }

    /**
     * 五分钟执行一次
     */
    @Scheduled(cron = "0 0/5 * * * *")
    public void fiveMinutes() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = new Date();
        String var1 = format.format(date.getTime() - 60000);
        String var2 = format.format(date.getTime() - 120000);
        List<MonitorInfo> monitorInfoList = monitorService.findMonitorInfoByTime(300);
        excute(monitorInfoList, var1, var2);
        System.out.println("----------5分钟: " + monitorInfoList.size());
    }


    /**
     * 十五分钟执行一次
     */
    @Scheduled(cron = "0 0/15 * * * *")
    public void minute15() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = new Date();
        String var1 = format.format(date.getTime() - 60000);
        String var2 = format.format(date.getTime() - 120000);
        List<MonitorInfo> monitorInfoList = monitorService.findMonitorInfoByTime(900);
        excute(monitorInfoList, var1, var2);
        System.out.println("----------15分钟: " + monitorInfoList.size());
    }

    /**
     * 三十分钟执行一次
     */
    @Scheduled(cron = "0 0/30 * * * *")
    public void minute30() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = new Date();
        String var1 = format.format(date.getTime() - 60000);
        String var2 = format.format(date.getTime() - 120000);
        List<MonitorInfo> monitorInfoList = monitorService.findMonitorInfoByTime(1800);
        excute(monitorInfoList, var1, var2);
        System.out.println("----------30分钟: " + monitorInfoList.size());
    }

    /**
     * 一个小时执行一次
     */
    @Scheduled(cron = "0 0 0/1 * * *")
    public void minute60() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = new Date();
        String var1 = format.format(date.getTime() - 60000);
        String var2 = format.format(date.getTime() - 120000);
        List<MonitorInfo> monitorInfoList = monitorService.findMonitorInfoByTime(3600);
        excute(monitorInfoList, var1, var2);
        System.out.println("----------60分钟: " + monitorInfoList.size());
    }

    private void excute(List<MonitorInfo> monitorInfoList, String var1, String var2) {
        Map map = new HashMap();
        for (MonitorInfo info : monitorInfoList) {
            List<CloudInfo> cloudInfoList = searchService.search(info.getIndex(), "_doc", info.getUsername(), info.getId(),
                    var2, var1,false);
            map.put("data", cloudInfoList);
            map.put("info", info);
            System.out.println("----------excute: " + cloudInfoList.size());
            if (cloudInfoList != null && cloudInfoList.size() != 0)
                rabbitTemplate.convertAndSend(Global.exchange, "huayun.monitor.info", map);
        }
    }
}
