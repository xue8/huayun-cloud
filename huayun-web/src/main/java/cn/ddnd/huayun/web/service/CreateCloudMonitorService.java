package cn.ddnd.huayun.web.service;

import cn.ddnd.huayun.web.request.MonitorRequest;

public interface CreateCloudMonitorService {
    boolean createOnlyOnce(MonitorRequest request) throws Exception;
    boolean createAlways(MonitorRequest request);
    boolean createAverage(MonitorRequest request);
}
