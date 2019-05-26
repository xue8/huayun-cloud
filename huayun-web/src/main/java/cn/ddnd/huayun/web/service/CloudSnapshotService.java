package cn.ddnd.huayun.web.service;

import org.springframework.stereotype.Service;

public interface CloudSnapshotService {
    Object createCloudSnapshot(String accessKeyId, String accessKey, String region, String id,
                               String createType, String name, String description);
    Object deleteCloudSnapshot(String accessKeyId, String accessKey, String region, String snapshotId);
    Object queryCloudSnapshot(String accessKeyId, String accessKey, String region, String id);
    Object applyCloudSnapshot(String accessKeyId, String accessKey, String region, String snapshotId);
}
