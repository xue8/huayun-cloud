package cn.ddnd.huayun.web.service.impl;

import cn.ddnd.huayun.web.request.Execute.ExecuteRequest;
import cn.ddnd.huayun.web.request.Execute.ExecuteRequestCheckIdentity;
import cn.ddnd.huayun.web.service.CheckIdentityService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class CheckIdentityServiceImpl implements CheckIdentityService {

    @Override
    public Object check(String accessKeyId, String accessKey) {
        ExecuteRequest executeRequest = new ExecuteRequestCheckIdentity();
        Map map = new HashMap<>();
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        return executeRequest.execute(map);
    }

}
