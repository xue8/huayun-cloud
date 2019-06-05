package cn.ddnd.huayun.web.controller;

import cn.ddnd.huayun.web.service.CloudManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/cloud/manage/")
public class CloudManageController {

    @Autowired
    CloudManageService cloudManage;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("query")
    public Object query(@RequestParam("region") String region,
                        @Nullable @RequestParam("instanceId") String instanceId,
                        @RequestHeader("sessionId") String sessionId) {
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.queryCloud(accessKeyId, accessKey, region, instanceId);
    }

    @GetMapping("start")
    public Object start(@RequestParam("region") String region,
                        @RequestParam("id") String id,
                        @RequestHeader("sessionId") String sessionId) {
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.startCloud(accessKeyId, accessKey, region, id);
    }

    @GetMapping("stop")
    public Object stop(@RequestParam("region") String region,
                       @RequestParam("id") String id,
                       @RequestHeader("sessionId") String sessionId) {
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.stopCloud(accessKeyId, accessKey, region, id);
    }

    @GetMapping("reboot")
    public Object reboot(@RequestParam("region") String region,
                         @RequestParam("id") String id,
                         @RequestParam("force") boolean force,
                         @RequestHeader("sessionId") String sessionId) {
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.rebootCloud(accessKeyId, accessKey, region, id, force);
    }

    @GetMapping("delete")
    public Object delete(@RequestParam("region") String region,
                         @RequestParam("id") String id,
                         @RequestHeader("sessionId") String sessionId) {
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.deleteCloud(accessKeyId, accessKey, region, id);
    }

    @GetMapping("password")
    public Object password(@RequestParam("region") String region,
                           @RequestParam("id") String id,
                           @Nullable @RequestParam("password") String password,
                           @RequestHeader("sessionId") String sessionId) {
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.changeCloudPassword(accessKeyId, accessKey, region, id, password);
    }


    @GetMapping("rebuild")
    public Object password(@RequestParam("region") String region,
                           @RequestParam("id") String id,
                           @RequestParam("imageId") String imageId,
                           @Nullable @RequestParam("password") String password,
                           @RequestHeader("sessionId") String sessionId) {
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.rebuildCloud(accessKeyId, accessKey, region, id, imageId, password);
    }

    @GetMapping("modify")
    public Object modify(@RequestParam("region") String region,
                           @RequestParam("id") String id,
                           @RequestParam("name") String name,
                         @RequestHeader("sessionId") String sessionId) {
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.modifyCloudName(accessKeyId, accessKey, region, id, name);
    }

    @GetMapping("vnc")
    public Object modify(@RequestParam("region") String region,
                         @RequestParam("id") String id,
                         @RequestHeader("sessionId") String sessionId) {
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.cloudVncUrl(accessKeyId, accessKey, region, id);
    }

    @GetMapping("renew")
    public Object period(@RequestParam("region") String region,
                         @RequestParam("id") String id,
                         @RequestParam("period") String period,
                         @Nullable @RequestParam("payType") String payType,
                         @RequestHeader("sessionId") String sessionId) {
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.renewCloud(accessKeyId, accessKey, region, id, payType, period);
    }

    @GetMapping("resize")
    public Object resize(@RequestParam("region") String region,
                         @RequestParam("id") String id,
                         @RequestParam("instanceType") String instanceType,
                         @RequestHeader("sessionId") String sessionId) {
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.resizeCloud(accessKeyId, accessKey, region, id, instanceType);
    }

    @GetMapping("firewall")
    public Object firewallId(@RequestParam("region") String region,
                         @RequestParam("id") String id,
                         @RequestParam("firewallId") String firewallId,
                             @RequestHeader("sessionId") String sessionId) {
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.cloudChangeFirewall(accessKeyId, accessKey, region, id, firewallId);
    }

}
