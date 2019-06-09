package cn.ddnd.huayun.web.service;

import java.util.List;

public interface LoadBalancerService {
    List query(String accessKeyId, String accessKey, String region, String loadBalancerId);
    List queryInterfaces(String accessKeyId, String accessKey, String region, String netCardId,String networkId,String loadBalancerId);
    List queryPolicies(String accessKeyId, String accessKey, String region, String loadBalancerId);
    List queryConnections(String accessKeyId, String accessKey, String region, String loadBalancerId, String startTime, String endTime);
    List queryQueuedConnections(String accessKeyId, String accessKey, String region, String loadBalancerId, String startTime, String endTime);
    List queryConcurrent(String accessKeyId, String accessKey, String region, String loadBalancerId, String startTime, String endTime);
    List queryNewConnections(String accessKeyId, String accessKey, String region, String loadBalancerId, String startTime, String endTime);
    List queryConnectTime(String accessKeyId, String accessKey, String region, String loadBalancerId, String startTime, String endTime);
    List queryReponseTime(String accessKeyId, String accessKey, String region, String loadBalancerId, String startTime, String endTime);
    List queryIn(String loadBalancerId, String startTime, String endTime);
    List queryOut(String loadBalancerId, String startTime, String endTime);
    List queryStatusUp(String accessKeyId, String accessKey, String region, String loadBalancerId, String startTime, String endTime);
    List queryStatusDown(String accessKeyId, String accessKey, String region, String loadBalancerId, String startTime, String endTime);
}
