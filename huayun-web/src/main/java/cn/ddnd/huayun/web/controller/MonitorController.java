package cn.ddnd.huayun.web.controller;

import cn.ddnd.huayun.web.pojo.MonitorInfo;
import cn.ddnd.huayun.web.service.MonitorInfoService;
import cn.ddnd.huayun.web.service.MonitorRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MonitorController {

    @Autowired
    MonitorInfoService monitorService;
    @Autowired
    MonitorRecordService monitorRecordService;


    @GetMapping("/monitor")
    public Object monitor(@RequestParam("index") String index,
                        @RequestParam("id") String id,
                        @RequestParam("time") Integer time,
                        @RequestParam("cycle") Integer cycle,
                        @RequestParam("type") Integer type,
                        @RequestParam("threshold") Double threshold,
                        @RequestParam("username") String username,
                          @RequestParam("phone") String phone,
                          @RequestParam("email") String email,
                          @RequestHeader("sessionId") String sessionId) {
        MonitorInfo monitorInfo = new MonitorInfo();
        monitorInfo.setCycle(cycle);
        monitorInfo.setId(id);
        monitorInfo.setIndex(index);
        monitorInfo.setTime(time);
        monitorInfo.setType(type);
        monitorInfo.setThreshold(threshold);
        monitorInfo.setUsername(username);
        monitorInfo.setPhone(phone);
        monitorInfo.setEmail(email);
        monitorService.insertMonitorInfo(monitorInfo);
        return true;
    }

    @DeleteMapping("/monitor")
    public Object delete(@RequestParam("id") String id,
                         @RequestHeader("sessionId") String sessionId) {
        return monitorService.deleteMonitorInfoById(id);
    }

    @GetMapping("/monitorAll")
    public Object monitorAll(@RequestParam("username") String username,
                             @RequestHeader("sessionId") String sessionId) {
        return monitorService.findMonitorInfoByUsername(username);
    }


    @GetMapping("/monitor/record")
    public Object record(@RequestParam("username") String username,
                         @RequestHeader("sessionId") String sessionId) {
        return monitorRecordService.findMonitorRecordByUsername(username);
    }
}
