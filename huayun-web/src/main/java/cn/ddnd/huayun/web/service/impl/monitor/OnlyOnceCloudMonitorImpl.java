package cn.ddnd.huayun.web.service.impl.monitor;

import cn.ddnd.huayun.web.service.CloudMonitorService;
import cn.ddnd.huayun.web.service.CreateCloudMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnlyOnceCloudMonitorImpl implements CloudMonitorService {

    @Autowired
    CreateCloudMonitorService monitorService;

    @Override
    public boolean cloudCpuMonitor(String index, Integer minute, Integer cycle, Double threshold) {
        return false;
    }

    @Override
    public boolean cloudRamMonitor(String index, Integer minute, Integer cycle, Double threshold) {
        return false;
    }

    @Override
    public boolean cloudDiskUsedMonitor(String index, Integer minute, Integer cycle, Double threshold) {
        return false;
    }

    @Override
    public boolean cloudIoReadMonitor(String index, Integer minute, Integer cycle, Double threshold) {
        return false;
    }

    @Override
    public boolean cloudIoWriteMonitor(String index, Integer minute, Integer cycle, Double threshold) {
        return false;
    }

    @Override
    public boolean cloudFipInMonitor(String index, Integer minute, Integer cycle, Double threshold) {
        return false;
    }

    @Override
    public boolean cloudFipOutMonitor(String index, Integer minute, Integer cycle, Double threshold) {
        return false;
    }

}
