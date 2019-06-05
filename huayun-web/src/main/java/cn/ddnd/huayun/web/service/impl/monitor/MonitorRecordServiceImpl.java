package cn.ddnd.huayun.web.service.impl.monitor;

import cn.ddnd.huayun.web.mapper.MonitorRecordMapper;
import cn.ddnd.huayun.web.pojo.MonitorRecord;
import cn.ddnd.huayun.web.service.MonitorRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorRecordServiceImpl implements MonitorRecordService {

    @Autowired
    MonitorRecordMapper recordMapper;

    @Override
    public List<MonitorRecord> findMonitorRecordByUsername(String username) {
        return recordMapper.findMonitorRecordByUsername(username);
    }

}
