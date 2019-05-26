package cn.ddnd.huayun.web.controller;

import cn.ddnd.huayun.web.service.CloudManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
                        HttpSession session) {
        System.out.println("----------------");
        String sessionId = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.queryCloud(accessKeyId, accessKey, region);
    }

    @GetMapping("start")
    public Object query(@RequestParam("region") String region,
                        @RequestParam("id") String id,
                        HttpSession session) {
        String sessionId = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.startCloud(accessKeyId, accessKey, region, id);
    }

    @GetMapping("stop")
    public Object stop(@RequestParam("region") String region,
                        @RequestParam("id") String id,
                        HttpSession session) {
        String sessionId = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.stopCloud(accessKeyId, accessKey, region, id);
    }

    @GetMapping("reboot")
    public Object reboot(@RequestParam("region") String region,
                       @RequestParam("id") String id,
                       @RequestParam("force") boolean force,
                       HttpSession session) {
        String sessionId = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.rebootCloud(accessKeyId, accessKey, region, id, force);
    }

    @GetMapping("delete")
    public Object delete(@RequestParam("region") String region,
                         @RequestParam("id") String id,
                         HttpSession session) {
        String sessionId = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.deleteCloud(accessKeyId, accessKey, region, id);
    }

    @GetMapping("password")
    public Object password(@RequestParam("region") String region,
                           @RequestParam("id") String id,
                           @Nullable @RequestParam("password") String password,
                           HttpSession session) {
        String sessionId = session.getId();
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
                           HttpSession session) {
        String sessionId = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.rebuildCloud(accessKeyId, accessKey, region, id, imageId, password);
    }

    @GetMapping("modify")
    public Object modify(@RequestParam("region") String region,
                           @RequestParam("id") String id,
                           @RequestParam("name") String name,
                           HttpSession session) {
        String sessionId = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.modifyCloudName(accessKeyId, accessKey, region, id, name);
    }

    @GetMapping("vnc")
    public Object modify(@RequestParam("region") String region,
                         @RequestParam("id") String id,
                         HttpSession session) {
        String sessionId = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.cloudVncUrl(accessKeyId, accessKey, region, id);
    }

    @GetMapping("renew")
    public Object period(@RequestParam("region") String region,
                         @RequestParam("id") String id,
                         @RequestParam("period") String period,
                         @RequestParam("payType") String payType,
                         HttpSession session) {
        String sessionId = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.renewCloud(accessKeyId, accessKey, region, id, payType, period);
    }

    @GetMapping("resize")
    public Object resize(@RequestParam("region") String region,
                         @RequestParam("id") String id,
                         @RequestParam("instanceType") String instanceType,
                         HttpSession session) {
        String sessionId = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.resizeCloud(accessKeyId, accessKey, region, id, instanceType);
    }

    @GetMapping("firewall")
    public Object firewallId(@RequestParam("region") String region,
                         @RequestParam("id") String id,
                         @RequestParam("firewallId") String firewallId,
                         HttpSession session) {
        String sessionId = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.cloudChangeFirewall(accessKeyId, accessKey, region, id, firewallId);
    }

}
