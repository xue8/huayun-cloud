package cn.ddnd.huayun.web.service.impl;

import cn.ddnd.huayun.web.request.Execute.*;
import cn.ddnd.huayun.web.service.CloudManageService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CloudManageServiceImpl implements CloudManageService {

    /**
     *  查询云主机，可查询一条或多条记录，可根据名称等多个查询条件查询。
     * @param region 机房
     * @return 返回主机详细信息
     */
    @Override
    public Object queryCloud(String accessKeyId, String accessKey, String region) {

        ExecuteRequest cloudInfo = new ExecuteRequestCloudInfo();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "DescribeInstances");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        Object object = cloudInfo.execute(map);
        return object;
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
