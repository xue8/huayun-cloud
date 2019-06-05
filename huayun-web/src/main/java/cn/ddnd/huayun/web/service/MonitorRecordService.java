package cn.ddnd.huayun.web.service;

import cn.ddnd.huayun.web.pojo.MonitorRecord;

import java.util.List;

public interface MonitorRecordService {
    List<MonitorRecord> findMonitorRecordByUsername(String username);
}
