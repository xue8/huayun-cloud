package cn.ddnd.huayun.web.service.impl;

import cn.ddnd.huayun.web.request.Execute.*;
import cn.ddnd.huayun.web.service.CloudImagesService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CloudImagesServiceImpl implements CloudImagesService {

    /**
     * 创建自定义镜像，从指定的实例制作一个自定义镜像，
     * 使用这种方式创建的镜像总是非共享的，该镜像只有创建者可以使用。实例必须是关机状态。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param id 实例Id
     * @param name
     * @param description
     * @param volumeType 后端卷类型，仅支持云服务支持的，值可为：ssd、sata
     * @return
     */
    @Override
    public Object createCloudImages(String accessKeyId, String accessKey, String region, String id,
                                    String name, String description, String volumeType) {
        ExecuteRequest start = new ExecuteRequestCloudCreateImages();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "CaptureInstance");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("InstanceId", id);
        map.put("VolumeType.0", volumeType);
        map.put("Name", name);
        map.put("Description", description);
        Object object = start.execute(map);
        return object;
    }

    /**
     * 删除镜像，根据镜像标识删除镜像，同时也会删除对应的模板、盘、快照信息，前提是该镜像下没有云主机了。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param imagesId
     * @return
     */
    @Override
    public Object deleteCloudImages(String accessKeyId, String accessKey, String region, String imagesId) {
        ExecuteRequest start = new ExecuteRequestCloudDeleteImages();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "DeleteImage");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Id", imagesId);
        Object object = start.execute(map);
        return object;
    }

    /**
     * 查询镜像信息，查询一条或者多条可用镜像信息，可根据标识、操作系统标识、用途、名称等条件查询。
     * 默认查询出公有镜像，如果查询出自定义镜像，Shared需要传false。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param imagesId 镜像id，支持批量，N为自然数，格式：&Id.0=xxx&Id.1=xxx等，没有填写则查询全部
     * @return
     */
    @Override
    public Object queryCloudImages(String accessKeyId, String accessKey, String region, String imagesId) {
        ExecuteRequest start = new ExecuteRequestCloudQueryImages();
        Map map = new HashMap();
        map.put("Region", region);
        map.put("Action", "DescribeImages");
        map.put("AccessKeyId", accessKeyId);
        map.put("AccessKey", accessKey);
        map.put("Shared", "false");
        if (imagesId != null && !imagesId.equals(""))
            map.put("Id.0 ", imagesId);
        Object object = start.execute(map);
        return object;
    }

    /**
     * 修改镜像的一些信息，根据镜像标识修改名称、操作系统标识、是否共享、是否支持热升级、描述等。
     * @param accessKeyId
     * @param accessKey
     * @param region
     * @param snapshotId
     * @return
     */
    @Override
    public Object modifyCloudImage(String accessKeyId, String accessKey, String region, String snapshotId) {
        return null;
    }
}
