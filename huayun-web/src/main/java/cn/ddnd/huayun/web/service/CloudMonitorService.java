package cn.ddnd.huayun.web.service;

public interface CloudMonitorService {
    boolean cloudCpuMonitor(String index, Integer minute, Integer cycle, Double threshold);
    boolean cloudRamMonitor(String index, Integer minute, Integer cycle, Double threshold);
    boolean cloudDiskUsedMonitor(String index, Integer minute, Integer cycle, Double threshold);
    boolean cloudIoReadMonitor(String index, Integer minute, Integer cycle, Double threshold);
    boolean cloudIoWriteMonitor(String index, Integer minute, Integer cycle, Double threshold);
    boolean cloudFipInMonitor(String index, Integer minute, Integer cycle, Double threshold);
    boolean cloudFipOutMonitor(String index, Integer minute, Integer cycle, Double threshold);
}
