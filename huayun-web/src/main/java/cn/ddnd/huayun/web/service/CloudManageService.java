package cn.ddnd.huayun.web.service;

public interface CloudManageService {
    Object queryCloud(String accessKeyId, String accessKey, String region, String instanceId);
    Object startCloud(String accessKeyId, String accessKey, String region, String id);
    Object stopCloud(String accessKeyId, String accessKey, String region, String id);
    Object rebootCloud(String accessKeyId, String accessKey, String region, String id, boolean force);
    Object deleteCloud(String accessKeyId, String accessKey, String region, String id);
    Object changeCloudPassword(String accessKeyId, String accessKey, String region, String id, String password);
    Object rebuildCloud(String accessKeyId, String accessKey, String region, String id, String imageId, String password);
    Object modifyCloudName(String accessKeyId, String accessKey, String region, String id, String name);
    Object cloudVncUrl(String accessKeyId, String accessKey, String region, String id);
    Object renewCloud(String accessKeyId, String accessKey, String region, String id, String payType, String period);
    Object resizeCloud(String accessKeyId, String accessKey, String region, String id, String instanceType);
    Object cloudChangeFirewall(String accessKeyId, String accessKey, String region, String id, String firewallId);
}
