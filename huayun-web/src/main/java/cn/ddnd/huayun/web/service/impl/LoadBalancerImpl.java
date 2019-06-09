package cn.ddnd.huayun.web.service.impl;

import cn.ddnd.huayun.es.service.SearchService;
import cn.ddnd.huayun.web.pojo.CloudInfo;
import cn.ddnd.huayun.web.request.Execute.ExecuteRequest;
import cn.ddnd.huayun.web.request.Execute.ExecuteRequestLoadBalancer;
import cn.ddnd.huayun.web.request.Execute.ExecuteRequestRouter;
import cn.ddnd.huayun.web.service.LoadBalancerService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoadBalancerImpl implements LoadBalancerService {

    @Reference
    SearchService searchService;

    /**
     * 查询负载均衡器
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param loadBalancerId 留空则查询全部负载均衡器
     * @return
     */
    @Override
    public List query(String accessKeyId, String accessKey, String region, String loadBalancerId) {
        ExecuteRequest loadBalancer = new ExecuteRequestLoadBalancer();
        Map map = new HashMap();
        map.put("Action", "DescribeLoadBalancers");
        map.put("Region", region);
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        if (loadBalancerId != null && !loadBalancerId.equals(""))
            map.put("Id.0", loadBalancerId);
        Object object = loadBalancer.execute(map);
        Map map1 = JSON.parseObject(JSON.toJSONString(object), Map.class);
        List list1 = JSON.parseObject(JSON.toJSONString(map1.get("loadBalancerSet")), List.class);
        List result = new ArrayList();
        if (list1 == null || list1.size() == 0)
            return result;
        for (Object o : list1) {
            Map map2 = JSON.parseObject(JSON.toJSONString(o), Map.class);
            result.add(map2);
        }
        return result;
    }

    /**
     * 查询负载均衡器实例已加入的私有网络
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param netCardId 留空则查询全部
     * @param networkId 留空则查询全部
     * @param loadBalancerId 留空则查询全部
     * @return
     */
    @Override
    public List queryInterfaces(String accessKeyId, String accessKey, String region, String netCardId, String networkId, String loadBalancerId) {
        ExecuteRequest loadBalancer = new ExecuteRequestLoadBalancer();
        Map map = new HashMap();
        map.put("Action", "DescribeLoadBalancerInterfaces");
        map.put("Region", region);
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        if (netCardId != null && !netCardId.equals(""))
            map.put("Id.0", netCardId);
        if (networkId != null && !networkId.equals(""))
            map.put("NetworkId", networkId);
        if (loadBalancerId != null && !loadBalancerId.equals(""))
            map.put("LoadBalancer.0", loadBalancerId);
        Object object = loadBalancer.execute(map);
        Map map1 = JSON.parseObject(JSON.toJSONString(object), Map.class);
        List list1 = JSON.parseObject(JSON.toJSONString(map1.get("lBInterface")), List.class);
        List result = new ArrayList();
        for (Object o : list1) {
            Map map2 = JSON.parseObject(JSON.toJSONString(o), Map.class);
            result.add(map2);
        }
        return result;
    }

    /**
     * 查询负载均衡器实例转发策略
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param loadBalancerId
     * @return
     */
    @Override
    public List queryPolicies(String accessKeyId, String accessKey, String region, String loadBalancerId) {
        ExecuteRequest loadBalancer = new ExecuteRequestLoadBalancer();
        Map map = new HashMap();
        map.put("Action", "DescribeLBPolicies");
        map.put("Region", region);
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        if (loadBalancerId != null && !loadBalancerId.equals(""))
            map.put("LBId", loadBalancerId);
        Object object = loadBalancer.execute(map);
        Map map1 = JSON.parseObject(JSON.toJSONString(object), Map.class);
        List list1 = JSON.parseObject(JSON.toJSONString(map1.get("lBPolicySet")), List.class);
        List result = new ArrayList();
        for (Object o : list1) {
            Map map2 = JSON.parseObject(JSON.toJSONString(o), Map.class);
            result.add(map2);
        }
        return result;
    }

    /**
     * 均衡器活跃连接数
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param loadBalancerId
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List queryConnections(String accessKeyId, String accessKey, String region, String loadBalancerId, String startTime, String endTime) {
        return null;
    }

    @Override
    public List queryQueuedConnections(String accessKeyId, String accessKey, String region, String loadBalancerId, String startTime, String endTime) {
        return null;
    }

    @Override
    public List queryConcurrent(String accessKeyId, String accessKey, String region, String loadBalancerId, String startTime, String endTime) {
        return null;
    }

    @Override
    public List queryNewConnections(String accessKeyId, String accessKey, String region, String loadBalancerId, String startTime, String endTime) {
        return null;
    }

    @Override
    public List queryConnectTime(String accessKeyId, String accessKey, String region, String loadBalancerId, String startTime, String endTime) {
        return null;
    }

    @Override
    public List queryReponseTime(String accessKeyId, String accessKey, String region, String loadBalancerId, String startTime, String endTime) {
        return null;
    }

    @Cacheable("lb")
    @Override
    public List queryIn(String loadBalancerId, String startTime, String endTime) {
        List<CloudInfo> list = searchService.search("lb_lb_in", "_doc", "xue8", loadBalancerId, startTime, endTime, true);
        if (list.size() != 0)
            return list;
        return null;
    }

    @Cacheable("lb")
    @Override
    public List queryOut(String loadBalancerId, String startTime, String endTime) {
        List<CloudInfo> list = searchService.search("lb_lb_out", "_doc", "xue8", loadBalancerId, startTime, endTime, true);
        if (list.size() != 0)
            return list;
        return null;
    }


    @Override
    public List queryStatusUp(String accessKeyId, String accessKey, String region, String loadBalancerId, String startTime, String endTime) {
        return null;
    }

    @Override
    public List queryStatusDown(String accessKeyId, String accessKey, String region, String loadBalancerId, String startTime, String endTime) {
        return null;
    }

}
