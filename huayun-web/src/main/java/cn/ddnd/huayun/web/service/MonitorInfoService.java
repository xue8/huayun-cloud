package cn.ddnd.huayun.web.service;

import cn.ddnd.huayun.web.pojo.MonitorInfo;

import java.util.List;

public interface MonitorInfoService {
    boolean insertMonitorInfo(MonitorInfo info);
    List<MonitorInfo> findMonitorInfoById(String id);
    List<MonitorInfo> findMonitorInfoByIdAndTime(String id, Integer time);
    List<MonitorInfo> findMonitorInfoByTime(Integer time);
    boolean deleteMonitorInfoById(String id);
}
