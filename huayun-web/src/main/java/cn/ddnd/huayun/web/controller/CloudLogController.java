package cn.ddnd.huayun.web.controller;

import cn.ddnd.huayun.web.pojo.CloudInfo;
import cn.ddnd.huayun.web.pojo.CloudRequest;
import cn.ddnd.huayun.web.service.CloudService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cloud/")
public class CloudLogController {

    @Autowired
    CloudService cloudService;

    @GetMapping("info")
    public Object info(@RequestParam("index") String index,
                       @Nullable @RequestParam("type") String type,
                      @RequestParam("username") String username,
                      @RequestParam("id") String id,
                      @Nullable @RequestParam("startDatetime") String startDatetime,
                      @Nullable @RequestParam("endDatetime") String endDatetime,
                      @Nullable @RequestParam("start") Double start,
                      @Nullable @RequestParam("end") Double end,
                      @Nullable @RequestParam("sort") boolean sort,
                      @RequestHeader("sessionId") String sessionId) {
        CloudRequest request = new CloudRequest();
        request.setUsername(username);
        request.setIndex(index);
        request.setType("_doc");
        request.setId(id);
        request.setStartDatetime(startDatetime);
        request.setEndDatetime(endDatetime);
        request.setStart(start);
        request.setEnd(end);
        request.setSort(sort);
        List<CloudInfo> list = cloudService.search(request);
        int total = list.size();
        Map result = new HashMap();
        result.put("data", list);
        result.put("total", total);
        result.put("index", index);
        return JSON.toJSONString(result);
    }

}
