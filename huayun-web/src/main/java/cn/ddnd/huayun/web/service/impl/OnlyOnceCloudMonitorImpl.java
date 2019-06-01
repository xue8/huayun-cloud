package cn.ddnd.huayun.web.service.impl;

import cn.ddnd.huayun.web.service.CloudMonitor;
import org.springframework.stereotype.Service;

@Service
public class OnlyOnceCloudMonitorImpl implements CloudMonitor {
    @Override
    public boolean cloudCpuMonitor(String value, Integer minute, Integer cycle, Integer threshold) {
        return false;
    }

    @Override
    public boolean cloudRamMonitor(String value, Integer minute, Integer cycle, Integer threshold) {
        return false;
    }

    @Override
    public boolean cloudDiskUsedMonitor(String value, Integer minute, Integer cycle, Integer threshold) {
        return false;
    }

    @Override
    public boolean cloudIoReadMonitor(String value, Integer minute, Integer cycle, Integer threshold) {
        return false;
    }

    @Override
    public boolean cloudIoWriteMonitor(String value, Integer minute, Integer cycle, Integer threshold) {
        return false;
    }

    @Override
    public boolean cloudFipInMonitor(String value, Integer minute, Integer cycle, Integer threshold) {
        return false;
    }

    @Override
    public boolean cloudFipOutMonitor(String value, Integer minute, Integer cycle, Integer threshold) {
        return false;
    }
}
