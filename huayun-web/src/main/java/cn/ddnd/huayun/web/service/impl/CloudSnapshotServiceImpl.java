package cn.ddnd.huayun.web.service.impl;

import cn.ddnd.huayun.web.request.Execute.*;
import cn.ddnd.huayun.web.service.CloudSnapshotService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CloudSnapshotServiceImpl implements CloudSnapshotService {

    /**
     * 创建云主机快照，仅仅创建系统盘快照。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param id
     * @param createType 快照创建类型，取值范围，CUSTOMER-用户手动创建
     * @param name 名称
     * @param description 描述
     * @return
     */
    @Override
    public Object createCloudSnapshot(String accessKeyId, String accessKey, String region, String id, String createType, String name, String description) {
        ExecuteRequest start = new ExecuteRequestCloudCreateSnapshot();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "CreateInstanceSnapshot");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("InstanceId", id);
        map.put("CreateType", createType);
        if (name != null && !name.equals(""))
            map.put("Name", name);
        if (description != null && !description.equals(""))
            map.put("Description", description);
        Object object = start.execute(map);
        return object;
    }

    /**
     * 删除云主机快照，同时会删除对应的系统盘快照信息。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param snapshotId 云主机快照标识
     * @return
     */
    @Override
    public Object deleteCloudSnapshot(String accessKeyId, String accessKey, String region, String snapshotId) {
        ExecuteRequest start = new ExecuteRequestCloudDeleteSnapshot();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "DeleteInstanceSnapshot");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Id", snapshotId);
        Object object = start.execute(map);
        return object;
    }

    /**
     * 查询云主机快照信息，可根据查询条件查询多条记录。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param id 云主机ID，留空则为查询全部
     * @return
     */
    @Override
    public Object queryCloudSnapshot(String accessKeyId, String accessKey, String region, String id) {
        ExecuteRequest start = new ExecuteRequestCloudQuerySnapshots();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "DeleteInstanceSnapshot");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        if (id != null && id.equals(""))
            map.put("InstanceId.0", id);
        Object object = start.execute(map);
        return object;
    }

    /**
     * 云主机快照还原，仅仅还原对应的云主机系统盘，
     * 数据盘不会还原，如果需要还原数据盘需要单独还原云硬盘快照。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param snapshotId 要还原的实例快照标识
     * @return
     */
    @Override
    public Object applyCloudSnapshot(String accessKeyId, String accessKey, String region, String snapshotId) {
        ExecuteRequest start = new ExecuteRequestCloudApplySnapshot();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "DeleteInstanceSnapshot");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Id", snapshotId);
        Object object = start.execute(map);
        return object;
    }
}
