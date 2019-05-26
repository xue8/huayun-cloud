package cn.ddnd.huayun.web.service;

public interface CloudImagesService {
    Object createCloudImages(String accessKeyId, String accessKey, String region, String id,
                             String name, String description, String volumeType);
    Object deleteCloudImages(String accessKeyId, String accessKey, String region, String imagesId);
    Object queryCloudImages(String accessKeyId, String accessKey, String region, String imagesId);
    Object modifyCloudImage(String accessKeyId, String accessKey, String region, String imagesId);
}
