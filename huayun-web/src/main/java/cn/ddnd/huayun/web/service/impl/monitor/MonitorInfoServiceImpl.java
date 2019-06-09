package cn.ddnd.huayun.web.service.impl.monitor;

import cn.ddnd.huayun.web.mapper.MonitorInfoMapper;
import cn.ddnd.huayun.web.pojo.MonitorInfo;
import cn.ddnd.huayun.web.service.MonitorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorInfoServiceImpl implements MonitorInfoService {

    @Autowired
    MonitorInfoMapper monitorInfoMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean insertMonitorInfo(MonitorInfo info) {
        stringRedisTemplate.delete("monitor_info::" + info.getUsername());
        return monitorInfoMapper.insertMonitorInfo(info);
    }

    @Cacheable("monitor_info")
    @Override
    public List<MonitorInfo> findMonitorInfoById(String id) {
        return monitorInfoMapper.findMonitorInfoById(id);
    }

    @Override
    public List<MonitorInfo> findMonitorInfoByMonitorId(String id) {
        return monitorInfoMapper.findMonitorInfoByMonitorId(id);
    }

    @Cacheable("monitor_info")
    @Override
    public List<MonitorInfo> findMonitorInfoByUsername(String username) {
        return monitorInfoMapper.findMonitorInfoByUsername(username);
    }

    @Cacheable("monitor_info")
    @Override
    public List<MonitorInfo> findMonitorInfoByIdAndTime(String id, Integer time) {
        return monitorInfoMapper.findMonitorInfoByIdAndTime(id, time);
    }

//    @Cacheable("monitor_info")
    @Override
    public List<MonitorInfo> findMonitorInfoByTime(Integer time) {
        return monitorInfoMapper.findMonitorInfoByTime(time);
    }

    @Override
    public boolean deleteMonitorInfoById(String id) {
        List<MonitorInfo> list = this.findMonitorInfoByMonitorId(id);
        String username = "";
        if (list != null || list.size() != 0)
            username = list.get(0).getUsername();
        stringRedisTemplate.delete("monitor_info::" + username);
        stringRedisTemplate.delete("monitor_info::60");
        stringRedisTemplate.delete("monitor_info::300");
        stringRedisTemplate.delete("monitor_info::900");
        stringRedisTemplate.delete("monitor_info::1800");
        stringRedisTemplate.delete("monitor_info::3600");
        return monitorInfoMapper.deleteMonitorInfo(id);
    }
}
