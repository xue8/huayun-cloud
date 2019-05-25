package cn.ddnd.huayun.web.controller;

import cn.ddnd.huayun.web.service.CloudManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
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
                        @RequestParam("action") String action,
                        HttpSession session) {
        String id = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + id);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return cloudManage.queryCloud(accessKeyId, accessKey, region, action);
    }

}
