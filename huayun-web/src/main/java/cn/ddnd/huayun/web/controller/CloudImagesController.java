package cn.ddnd.huayun.web.controller;

import cn.ddnd.huayun.web.service.CloudImagesService;
import cn.ddnd.huayun.web.service.CloudSnapshotService;
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
@RequestMapping("/cloud/images")
public class CloudImagesController {

    @Autowired
    CloudImagesService imagesService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("create")
    public Object create(@RequestParam("region") String region,
                        @RequestParam("id") String id,
                        @RequestParam("volumeType") String volumeType,
                        @RequestParam("name") String name,
                        @RequestParam("description") String description,
                        HttpSession session) {
        String sessionId = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return imagesService.createCloudImages(accessKeyId, accessKey, region, id,
                name, description, volumeType);
    }

    @GetMapping("delete")
    public Object delete(@RequestParam("region") String region,
                        @RequestParam("imagesId") String imagesId,
                        HttpSession session) {
        String sessionId = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return imagesService.deleteCloudImages(accessKeyId, accessKey, region, imagesId);
    }

    @GetMapping("query")
    public Object query(@RequestParam("region") String region,
                        @Nullable @RequestParam("imagesId") String imagesId,
                        HttpSession session) {
        String sessionId = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
            return imagesService.queryCloudImages(accessKeyId, accessKey, region, imagesId);
    }

}
