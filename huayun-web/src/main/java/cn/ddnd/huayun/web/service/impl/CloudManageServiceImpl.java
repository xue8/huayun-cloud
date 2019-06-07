package cn.ddnd.huayun.web.service.impl;

import cn.ddnd.huayun.web.config.Global;
import cn.ddnd.huayun.web.pojo.Cloud;
import cn.ddnd.huayun.web.request.Execute.*;
import cn.ddnd.huayun.web.service.CloudManageService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CloudManageServiceImpl implements CloudManageService {

    /**
     *  查询云主机，可查询一条或多条记录，可根据名称等多个查询条件查询。
     * @param region 机房
     * @return 返回主机详细信息
     */
    @Override
    public Object queryCloud(String accessKeyId, String accessKey, String region, String instanceId) {

        ExecuteRequest cloudInfo = new ExecuteRequestCloudInfo();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "DescribeInstances");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        if (instanceId != null && !instanceId.equals("")) {
            map.put("Id.0", instanceId);
        }
        Object object = cloudInfo.execute(map);
        if (instanceId != null && !instanceId.equals("")) {
            return object;
        }
        String jsonStr = JSON.toJSONString(object);
        Map<String, Object> map1 = (Map) JSON.parse(jsonStr);
        List list = (List) map1.get("instanceSet");
        if (list == null)
            return "{\"data\": []}";
        List<Cloud> result = new ArrayList<>();
        for (Object object1 : list) {
            Map map2 = (Map) object1;
            Cloud cloud = new Cloud();
            cloud.setId((String) map2.get("Id"));
            cloud.setName((String) map2.get("Name"));
            List list1 = (List) map2.get("Internet");
            for (Object object2 : list1) {
                Map map3 = (Map) object2;
                cloud.setPublicIp(cloud.getPublicIp() + ";" + map3.get("IpAddress"));
                cloud.setBandWidth((Integer) map3.get("Bandwidth"));
            }
            cloud.setPublicIp(cloud.getPublicIp().replaceAll("null;", ""));
            List list2 = (List) map2.get("InterfaceSet");
            for (Object object2 : list2) {
                Map map3 = (Map) object2;
                cloud.setPrivateIp(cloud.getPrivateIp() + ";" + map3.get("IpAddress"));
            }
            cloud.setPrivateIp(cloud.getPrivateIp().replaceAll("null;", ""));
            cloud.setSeriesName((String) map2.get("SeriesName"));
            cloud.setCpu((Integer) map2.get("Cpu"));
            cloud.setMemory((Integer) map2.get("Memory"));
            cloud.setMemory((Integer) map2.get("Memory"));
            cloud.setOsName((String) map2.get("OsName"));
            cloud.setStatus((String) map2.get("Status"));
            cloud.setDueTime((String) map2.get("DueTime"));
            cloud.setProductStatus((String) map2.get("ProductStatus"));
            result.add(cloud);
        }
        Map map2 = new HashMap();
        map2.put("data", result);
        return map2;
    }

    /**
     * 查询主机总数，以及正常、过期、欠费的数量
     * @param accessKeyId
     * @param accessKey
     * @return
     */
    @Override
    public Object queryCloud(String accessKeyId, String accessKey) {
        List<String> list = Global.region;
        Map result = new HashMap();
        result.put("normal", 0);
        result.put("overtimer", 0);
        result.put("arrearage", 0);
        result.put("total", 0);
        for (String str : list) {
            Object o = this.queryCloud(accessKeyId, accessKey, str, null);
            if (!o.equals("{\"data\": []}")) {
                Map map = JSON.parseObject(JSON.toJSONString(o), Map.class);
                List list1 = JSON.parseObject(JSON.toJSONString(map.get("data")), List.class);
                for (Object o1 : list1) {
                    Map map1 = JSON.parseObject(JSON.toJSONString(o1), Map.class);
                    if (map1.get("productStatus").equals("NORMAL"))
                        result.put("normal", (Integer) result.get("normal") + 1);
                    if (map1.get("productStatus").equals("OVERTIMER"))
                        result.put("overtimer", (Integer) result.get("overtimer") + 1);
                    if (map1.get("productStatus").equals("ARREARAGE"))
                        result.put("arrearage", (Integer) result.get("arrearage") + 1);
                    result.put("total", (Integer) result.get("total") + 1);
                }
            }
        }
        return result;
    }

    /**
     * 查询机房所有主机的状态
     * @param accessKeyId
     * @param accessKey
     * @return
     */
    @Override
    public Object queryCloudStatus(String accessKeyId, String accessKey) {
        List<String> list = Global.region;
        List result = new ArrayList();
        for (String str : list) {
            Object o = this.queryCloud(accessKeyId, accessKey, str, null);
            Map map1 = new HashMap();
            if (!o.equals("{\"data\": []}")) {
                Map map = JSON.parseObject(JSON.toJSONString(o), Map.class);
                List list1 = JSON.parseObject(JSON.toJSONString(map.get("data")), List.class);
                map1.put("region", str);
                map1.put("totalCount", list1.size());
                map1.put("start", 0);
                map1.put("stop", 0);
                map1.put("error", 0);
                map1.put("other", 0);
                map1.put("normal", 0);
                map1.put("overtimer", 0);
                map1.put("arrearage", 0);
                for (Object o1 : list1) {
                    Map map2 = JSON.parseObject(JSON.toJSONString(o1), Map.class);
                    if (map2.get("status").equals("START"))
                        map1.put("start", (Integer) map1.get("start") + 1);
                    if (map2.get("status").equals("STOP"))
                        map1.put("stop", (Integer) map1.get("stop") + 1);
                    if (map2.get("status").equals("ERROR"))
                        map1.put("error", (Integer) map1.get("error") + 1);
                    if (!map2.get("status").equals("START") && !map2.get("status").equals("STOP") && !map2.get("status").equals("ERROR"))
                        map1.put("other", (Integer) map1.get("other") + 1);
                    if (map2.get("productStatus").equals("NORMAL"))
                        map1.put("normal", (Integer) map1.get("normal") + 1);
                    if (map2.get("productStatus").equals("OVERTIMER"))
                        map1.put("overtimer", (Integer) map1.get("overtimer") + 1);
                    if (map2.get("productStatus").equals("ARREARAGE"))
                        map1.put("arrearage", (Integer) map1.get("arrearage") + 1);
                    map1.put("totalCount", (Integer) map1.get("totalCount") + 1);
                }
            }
            if (map1.size() != 0)
                result.add(map1);
        }
        return result;
    }

    /**
     * 云主机开机，实例必须是关机状态。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param id
     * @return
     */
    @Override
    public Object startCloud(String accessKeyId, String accessKey, String region, String id) {
        ExecuteRequest start = new ExecuteRequestCloudStart();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "StartInstance");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Id", id);
        Object object = start.execute(map);
        return object;
    }

    /**
     * 关闭运行中的云主机，只能是运行中状态才能关机。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param id
     * @return
     */
    @Override
    public Object stopCloud(String accessKeyId, String accessKey, String region, String id) {
        ExecuteRequest start = new ExecuteRequestCloudStop();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "StopInstance");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Id", id);
        Object object = start.execute(map);
        return object;
    }

    /**
     * 重启云主机，云主机必须是开机或者关闭状态。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param id
     * @param force 是否强制执行，取值范围：true为硬重启,false为软重启
     * @return
     */
    @Override
    public Object rebootCloud(String accessKeyId, String accessKey, String region, String id, boolean force) {
        ExecuteRequest start = new ExecuteRequestCloudReboot();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "RebootInstance");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Id", id);
        map.put("Force", force);
        Object object = start.execute(map);
        return object;
    }

    /**
     * 删除过期云主机。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param id
     * @return
     */
    @Override
    public Object deleteCloud(String accessKeyId, String accessKey, String region, String id) {
        ExecuteRequest start = new ExecuteRequestCloudDelete();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "TerminateInstance");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Id", id);
        Object object = start.execute(map);
        return object;
    }

    /**
     * 更新云主机系统密码，云主机必须是开机状态下才能修改密码。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param id
     * @param password
     * @return
     */
    @Override
    public Object changeCloudPassword(String accessKeyId, String accessKey, String region, String id, String password) {
        ExecuteRequest start = new ExecuteRequestCloudChangePassword();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "ChangeInstancePassword");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Id", id);
        map.put("Password ", password);
        Object object = start.execute(map);
        return object;
    }

    /**
     * 云主机重装，云主机必须处于关机状态，可以选择想要重装的镜像标识，重装时可以修改密码。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param id
     * @param imageId
     * @param password 重装设置的新密码，由大小写字母、数字和特殊字符组成。如果为空则使用开通初始密码
     * @return
     */
    @Override
    public Object rebuildCloud(String accessKeyId, String accessKey, String region, String id, String imageId, String password) {
        ExecuteRequest start = new ExecuteRequestCloudRebuild();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "RebuildInstance");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Id", id );
        map.put("ImageId", imageId);
        if (password != null && !password.equals(""))
            map.put("Password ", password);
        Object object = start.execute(map);
        return object;
    }


    /**
     * 修改云主机的名称。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param id
     * @param name
     * @return
     */
    @Override
    public Object modifyCloudName(String accessKeyId, String accessKey, String region, String id, String name) {
        ExecuteRequest start = new ExecuteRequestCloudModifyName();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "ModifyInstanceAttributes");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Id", id);
        map.put("Name", name);
        Object object = start.execute(map);
        return object;
    }

    /**
     * 查询实例的管理终端地址。
     * 查询实例的管理终端地址有如下限制，管理终端地址的有效时间N秒。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param id
     * @return
     */
    @Override
    public Object cloudVncUrl(String accessKeyId, String accessKey, String region, String id) {
        ExecuteRequest start = new ExecuteRequestCloudVncUrl();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "DescribeInstanceVncUrl");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Id", id);
        Object object = start.execute(map);
        return object;
    }

    /**
     * 包年包月,试用情况下，对目前正在使用的实例续费。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param id
     * @param period
     * @return
     */
    @Override
    public Object renewCloud(String accessKeyId, String accessKey, String region, String id,
                             String payType,String period) {
        ExecuteRequest start = new ExecuteRequestCloudRenew();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "RenewInstance");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Id", id);
        map.put("Period", period);
        map.put("PayType", payType);
        Object object = start.execute(map);
        return object;
    }

    /**
     * 修改云主机配置，升级或者降级云主机。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param id
     * @param instanceType 实例的新资源规格，取值参见实例规格组
     * @return
     */
    @Override
    public Object resizeCloud(String accessKeyId, String accessKey, String region, String id, String instanceType) {
        ExecuteRequest start = new ExecuteRequestCloudResize();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "ResizeInstance");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Id", id);
        map.put("InstanceType", instanceType);
        Object object = start.execute(map);
        return object;
    }

    /**
     * 修改云主机防火墙。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param id
     * @param firewallId 新防火墙Id，可通过查找防火墙方法获取
     * @return
     */
    @Override
    public Object cloudChangeFirewall(String accessKeyId, String accessKey, String region, String id, String firewallId) {
        ExecuteRequest start = new ExecuteRequestCloudChangeFirewall();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "ChangeInstanceFirewall");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Id", id);
        map.put("FirewallId", firewallId);
        Object object = start.execute(map);
        return object;
    }

}
