package cn.ddnd.huayun.web.service.impl;

import cn.ddnd.huayun.web.request.Execute.ExecuteRequestCloudInfo;
import cn.ddnd.huayun.web.service.CloudManageService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CloudManageServiceImpl implements CloudManageService {

    /**
     *  查询用户主机信息
     * @param region
     * @param action
     * @return 返回主机详细信息
     */
    @Override
    public Object queryCloud(String accessKeyId, String accessKey, String region, String action) {

        ExecuteRequestCloudInfo cloudInfo = new ExecuteRequestCloudInfo();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", action);
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        Object object = cloudInfo.execute(map);
        return object;
    }
}
