package cn.ddnd.huayun.web.service.impl;

import cn.ddnd.huayun.es.service.SearchService;
import cn.ddnd.huayun.web.pojo.CloudInfo;
import cn.ddnd.huayun.web.request.Execute.ExecuteRequestRouter;
import cn.ddnd.huayun.web.service.RouterService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RouterServiceImpl implements RouterService {
    @Reference
    SearchService searchService;

    @Override
    public List queryRouter(String accessKeyId, String accessKey, String region, String routerId) {
        ExecuteRequestRouter router = new ExecuteRequestRouter();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "DescribeRouters");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        if (routerId != null && !routerId.equals(""))
            map.put("Id.0", routerId);
        Object object = router.execute(map);
        Map map1 = JSON.parseObject(JSON.toJSONString(object), Map.class);
        List list1 = JSON.parseObject(JSON.toJSONString(map1.get("routerSet")), List.class);
        List result = new ArrayList();
        for (Object o : list1) {
            Map map2 = JSON.parseObject(JSON.toJSONString(o), Map.class);
            result.add(map2);
        }
        return result;
    }

    @Override
    public Object deleteRouter(String accessKeyId, String accessKey, String region, String routerId) {
        ExecuteRequestRouter router = new ExecuteRequestRouter();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "DeleteRouter");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Id", routerId);
        Object object = router.execute(map);
        return object;
    }

    @Override
    public Object startRouter(String accessKeyId, String accessKey, String region, String routerId) {
        ExecuteRequestRouter router = new ExecuteRequestRouter();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "StartRouter");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Id", routerId);
        Object object = router.execute(map);
        return object;
    }

    @Override
    public Object stopRouter(String accessKeyId, String accessKey, String region, String routerId) {
        ExecuteRequestRouter router = new ExecuteRequestRouter();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "StopRouter");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Id", routerId);
        Object object = router.execute(map);
        return object;
    }

    @Override
    public Object assignRouter(String accessKeyId, String accessKey, String region, String routerId, String eip) {
        ExecuteRequestRouter router = new ExecuteRequestRouter();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "AssignRouterEip");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("RouterId", routerId);
        map.put("Eip", eip);
        Object object = router.execute(map);
        return object;
    }

    @Override
    public Object removeRouter(String accessKeyId, String accessKey, String region, String routerId) {
        ExecuteRequestRouter router = new ExecuteRequestRouter();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "RemoveRouterEip");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("RouterId", routerId);
        Object object = router.execute(map);
        return object;
    }

    @Override
    public Object createRouterInterface(String accessKeyId, String accessKey, String region, String routerId, String networkId) {
        ExecuteRequestRouter router = new ExecuteRequestRouter();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "CreateRouterInterface");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("RouterId", routerId);
        map.put("NetworkId", networkId);
        Object object = router.execute(map);
        return object;
    }

    @Override
    public Object deleteRouterInterface(String accessKeyId, String accessKey, String region, String netCardId) {
        ExecuteRequestRouter router = new ExecuteRequestRouter();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "DeleteRouterInterface");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Id", netCardId);
        Object object = router.execute(map);
        return object;
    }

    @Override
    public Object modifyRouter(String accessKeyId, String accessKey, String region, String routerId, String name, String description) {
        ExecuteRequestRouter router = new ExecuteRequestRouter();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "ModifyRouterAttributes");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Name", name);
        map.put("Description", description);
        Object object = router.execute(map);
        return object;
    }

    @Override
    public List queryRouterInterface(String accessKeyId, String accessKey, String region, String routerId, String networkId, String netCardId) {
        ExecuteRequestRouter router = new ExecuteRequestRouter();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "DescribeRouterInterfaces");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        if (routerId != null && !routerId.equals(""))
            map.put("RouterId.0", routerId);
        if (netCardId != null && !netCardId.equals(""))
            map.put("Id.0", netCardId);
        if (networkId != null && !networkId.equals(""))
            map.put("NetworkId.0", networkId);
        Object object = router.execute(map);
        Map map1 = JSON.parseObject(JSON.toJSONString(object), Map.class);
        List list1 = JSON.parseObject(JSON.toJSONString(map1.get("routerInterfaceSet")), List.class);
        List result = new ArrayList();
        for (Object o : list1) {
            Map map2 = JSON.parseObject(JSON.toJSONString(o), Map.class);
            result.add(map2);
        }
        return result;
    }

    @Override
    public List routerInMonitor(String routerId, String startTime, String endTime) {
        List<CloudInfo> list = searchService.search("router_router_in", "_doc", "xue8", routerId, startTime, endTime, true);
        if (list.size() != 0)
            return list;
        return null;
    }

    @Override
    public List routerOutMonitor(String routerId, String startTime, String endTime) {
        List<CloudInfo> list = searchService.search("router_router_out", "_doc", "xue8", routerId, startTime, endTime, true);
        if (list.size() != 0)
            return list;
        return null;
    }
}
