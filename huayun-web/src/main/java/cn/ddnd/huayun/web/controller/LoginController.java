package cn.ddnd.huayun.web.controller;

import cn.ddnd.huayun.web.service.CheckIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user/")
public class LoginController {

    @Autowired
    CheckIdentityService service;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @PostMapping("login")
    public String login(@RequestParam("accessKeyId") String accessKeyId,
                        @RequestParam("accessKey") String accessKey,
                        HttpSession session) {
        Map map = new HashMap<>();
        map.put("accessKeyId", accessKeyId);
        map.put("accessKey", accessKey);
        System.out.println(session.getId());
        stringRedisTemplate.opsForHash().putAll("user:" + session.getId(), map);
        stringRedisTemplate.expire("user:" + session.getId(), 30, TimeUnit.MINUTES);
        return "{\"sessionId\":\"" + session.getId() + "\"}";
    }

}
