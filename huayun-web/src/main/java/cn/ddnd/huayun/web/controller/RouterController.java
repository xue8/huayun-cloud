package cn.ddnd.huayun.web.controller;

import cn.ddnd.huayun.web.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/router/")
public class RouterController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RouterService routerService;

    @GetMapping("query")
    public Object query(@RequestParam("region") String region,
                        @Nullable @RequestParam("routerId") String routerId,
                        @RequestHeader("sessionId") String sessionId) {

        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return routerService.queryRouter(accessKeyId, accessKey, region, routerId);
    }

    @GetMapping("delete")
    public Object delete(@RequestParam("region") String region,
                        @RequestParam("routerId") String routerId,
                        @RequestHeader("sessionId") String sessionId) {

        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return routerService.deleteRouter(accessKeyId, accessKey, region, routerId);
    }

    @GetMapping("start")
    public Object start(@RequestParam("region") String region,
                         @RequestParam("routerId") String routerId,
                         @RequestHeader("sessionId") String sessionId) {

        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return routerService.startRouter(accessKeyId, accessKey, region, routerId);
    }

    @GetMapping("stop")
    public Object stop(@RequestParam("region") String region,
                       @RequestParam("routerId") String routerId,
                       @RequestHeader("sessionId") String sessionId) {

        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return routerService.stopRouter(accessKeyId, accessKey, region, routerId);
    }

    @GetMapping("assign")
    public Object assign(@RequestParam("region") String region,
                       @RequestParam("routerId") String routerId,
                       @RequestParam("eip") String eip,
                       @RequestHeader("sessionId") String sessionId) {

        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return routerService.assignRouter(accessKeyId, accessKey, region, routerId, eip);
    }

    @GetMapping("remove")
    public Object remove(@RequestParam("region") String region,
                         @RequestParam("routerId") String routerId,
                         @RequestHeader("sessionId") String sessionId) {

        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return routerService.removeRouter(accessKeyId, accessKey, region, routerId);
    }

    @GetMapping("createRouterInterface")
    public Object createRouterInterface(@RequestParam("region") String region,
                         @RequestParam("routerId") String routerId,
                         @RequestParam("networkId") String networkId,
                         @RequestHeader("sessionId") String sessionId) {

        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return routerService.createRouterInterface(accessKeyId, accessKey, region, routerId, networkId);
    }

    @GetMapping("deleteRouterInterface")
    public Object deleteRouterInterface(@RequestParam("region") String region,
                                        @RequestParam("netCardId") String netCardId,
                                        @RequestHeader("sessionId") String sessionId) {

        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return routerService.deleteRouterInterface(accessKeyId, accessKey, region, netCardId);
    }

    @GetMapping("modifyRouter")
    public Object modifyRouter(@RequestParam("region") String region,
                                        @RequestParam("routerId") String routerId,
                                        @RequestParam("name") String name,
                                        @RequestParam("description") String description,
                                        @RequestHeader("sessionId") String sessionId) {

        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return routerService.modifyRouter(accessKeyId, accessKey, region, routerId, name, description);
    }

    @GetMapping("queryRouterInterface")
    public Object queryRouterInterface(@RequestParam("region") String region,
                               @Nullable @RequestParam("routerId") String routerId,
                               @Nullable @RequestParam("networkId") String networkId,
                               @Nullable @RequestParam("netCardId") String netCardId,
                               @RequestHeader("sessionId") String sessionId) {

        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return routerService.queryRouterInterface(accessKeyId, accessKey, region, routerId, networkId, netCardId);
    }

    @GetMapping("routerInMonitor")
    public Object routerInMonitor(@RequestParam("routerId") String routerId,
                                   @RequestParam("startDatetime") String startTime,
                                   @RequestParam("endDatetime") String endTime,
                                   @RequestHeader("sessionId") String sessionId) {

        return routerService.routerInMonitor(routerId, startTime, endTime);
    }

    @GetMapping("routerOutMonitor")
    public Object routerOutMonitor(@RequestParam("routerId") String routerId,
                                  @RequestParam("startDatetime") String startTime,
                                  @RequestParam("endDatetime") String endTime,
                                  @RequestHeader("sessionId") String sessionId) {

        return routerService.routerOutMonitor(routerId, startTime, endTime);
    }
}
