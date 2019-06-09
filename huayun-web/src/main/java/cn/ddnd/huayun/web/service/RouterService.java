package cn.ddnd.huayun.web.service;

import java.util.List;

public interface RouterService {
    List queryRouter(String accessKeyId, String accessKey, String region, String routerId);
    Object deleteRouter(String accessKeyId, String accessKey, String region, String routerId);
    Object startRouter(String accessKeyId, String accessKey, String region, String routerId);
    Object stopRouter(String accessKeyId, String accessKey, String region, String routerId);
    Object assignRouter(String accessKeyId, String accessKey, String region, String routerId, String eip);
    Object removeRouter(String accessKeyId, String accessKey, String region, String routerId);
    Object createRouterInterface(String accessKeyId, String accessKey, String region, String routerId, String networkId);
    Object deleteRouterInterface(String accessKeyId, String accessKey, String region, String netCardId);
    Object modifyRouter(String accessKeyId, String accessKey, String region, String routerId, String name, String description);
    List queryRouterInterface(String accessKeyId, String accessKey, String region, String routerId, String networkId, String netCardId);
    List routerInMonitor(String routerId, String startTime, String endTime);
    List routerOutMonitor(String routerId, String startTime, String endTime);
}
