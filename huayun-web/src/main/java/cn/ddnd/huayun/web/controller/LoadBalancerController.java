package cn.ddnd.huayun.web.controller;

import cn.ddnd.huayun.web.service.LoadBalancerService;
import cn.ddnd.huayun.web.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/lb/")
public class LoadBalancerController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    LoadBalancerService loadBalancerService;

    @GetMapping("query")
    public Object query(@Nullable @RequestParam("loadBalancerId") String loadBalancerId,
                     @RequestParam("region") String region,
                     @RequestHeader("sessionId") String sessionId) {

        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return loadBalancerService.query(accessKeyId, accessKey,region, loadBalancerId);
    }

    @GetMapping("in")
    public Object in(@RequestParam("loadBalancerId") String loadBalancerId,
                      @RequestParam("startDatetime") String startTime,
                      @RequestParam("endDatetime") String endTime,
                      @RequestHeader("sessionId") String sessionId) {

        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        return loadBalancerService.queryIn(loadBalancerId, startTime, endTime);
    }

    @GetMapping("out")
    public Object out(@RequestParam("loadBalancerId") String loadBalancerId,
                     @RequestParam("startDatetime") String startTime,
                     @RequestParam("endDatetime") String endTime,
                     @RequestHeader("sessionId") String sessionId) {

        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        return loadBalancerService.queryOut(loadBalancerId, startTime, endTime);
    }

}
