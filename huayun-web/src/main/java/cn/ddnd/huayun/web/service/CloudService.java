package cn.ddnd.huayun.web.service;

import cn.ddnd.huayun.web.pojo.CloudInfo;
import cn.ddnd.huayun.web.pojo.CloudRequest;

import java.util.List;

public interface CloudService {
    List<CloudInfo> search(CloudRequest request);
}
