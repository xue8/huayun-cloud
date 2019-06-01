package cn.ddnd.huayun.web.service;

public interface CloudMonitor {
    boolean cloudCpuMonitor(String value, Integer minute, Integer cycle, Integer threshold);
    boolean cloudRamMonitor(String value, Integer minute, Integer cycle, Integer threshold);
    boolean cloudDiskUsedMonitor(String value, Integer minute, Integer cycle, Integer threshold);
    boolean cloudIoReadMonitor(String value, Integer minute, Integer cycle, Integer threshold);
    boolean cloudIoWriteMonitor(String value, Integer minute, Integer cycle, Integer threshold);
    boolean cloudFipInMonitor(String value, Integer minute, Integer cycle, Integer threshold);
    boolean cloudFipOutMonitor(String value, Integer minute, Integer cycle, Integer threshold);
}
