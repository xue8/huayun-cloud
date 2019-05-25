package cn.ddnd.huayun.web.service;

public interface CloudManageService {
    Object queryCloud(String accessKeyId, String accessKey, String region, String action);
}
