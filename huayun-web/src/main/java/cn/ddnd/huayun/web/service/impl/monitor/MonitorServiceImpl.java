package cn.ddnd.huayun.web.service.impl.monitor;

import cn.ddnd.huayun.web.config.Global;
import cn.ddnd.huayun.web.mail.EmailSender;
import cn.ddnd.huayun.web.mapper.MonitorRecordMapper;
import cn.ddnd.huayun.web.pojo.CloudInfo;
import cn.ddnd.huayun.web.pojo.MonitorInfo;
import cn.ddnd.huayun.web.pojo.MonitorRecord;
import cn.ddnd.huayun.web.service.MonitorService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    EmailSender emailSender;
    @Autowired
    MonitorRecordMapper recordMapper;

    @RabbitListener(queues = "huayun.monitor.info")
    @Override
    public void excute(Map message) {
        Map<String, Object> map = message;
        MonitorInfo info = JSON.parseObject(JSON.toJSONString(map.get("info")), MonitorInfo.class);
        List<CloudInfo> cloudInfoList = JSON.parseArray(JSON.toJSONString(map.get("data")), CloudInfo.class);
        if (info.getType() == 1)
            onlyOnce(info, cloudInfoList);
        if (info.getType() == 2)
            always(info, cloudInfoList);
        if (info.getType() == 3)
            average(info, cloudInfoList);

    }

    /**
      * 在有一个周期满足条件的情况下报警
     */
    private void onlyOnce(MonitorInfo info, List<CloudInfo> cloudInfoList) {
        Double threshold = info.getTotal() * info.getThreshold();
        for (CloudInfo cloudInfo : cloudInfoList) {
            if (cloudInfo.getUsed() >= threshold)
                emailSender.send(Global.monitorTitle,
                        "尊敬的华云用户，您好！您的云服务器id：" + info.getId() +
                                "，资源：" + info.getIndex() + "，使用率超过" + info.getThreshold() + "%" +
                                "，请及时处理！",
                        info.getEmail());
            record(info);
            break;
        }
    }

    /**
     * 在所有周期都满足条件的情况下报警
     */
    private void always(MonitorInfo info, List<CloudInfo> cloudInfoList) {
        Double threshold = info.getTotal() * info.getThreshold();
        String k = "monitor:" + info.getIndex() + ":" + info.getTime() + ":" + info.getId() + ":" + info.getMonitorInfoId();
        for (CloudInfo cloudInfo : cloudInfoList) {
            String v = "";
            v = stringRedisTemplate.opsForValue().get(k);
            if (v == null || v.equals("")) {
                v = "0";
                Long expire = (long) info.getCycle() * info.getTime() + 10;
                stringRedisTemplate.opsForValue().set(k, v, expire, TimeUnit.SECONDS);
            }
            if (cloudInfo.getUsed() >= threshold) {
                stringRedisTemplate.opsForValue().increment(k);
                break;
            }
        }
        String var1 = stringRedisTemplate.opsForValue().get(k);
        if (Integer.valueOf(var1) >= info.getCycle()) {
            emailSender.send(Global.monitorTitle,
                    "ww",
                    info.getEmail());
            stringRedisTemplate.delete(k);
            record(info);
        }
    }

    /**
     * 在周期内平均值满足条件的情况下报警
     */
    private void average(MonitorInfo info, List<CloudInfo> cloudInfoList) {
        Double threshold = info.getTotal() * info.getThreshold();
        String k = "monitor:" + info.getIndex() + ":" + info.getTime() + ":" + info.getId() + ":" + info.getMonitorInfoId();

        Double var1 = 0D;
        for (CloudInfo cloudInfo : cloudInfoList) {
            var1 += cloudInfo.getUsed();
        }
        var1 /= cloudInfoList.size();

        String v = "";
        v = stringRedisTemplate.opsForValue().get(k);
        if (v == null || v.equals("")) {
            v = String.valueOf(var1);
            Long expire = (long) info.getCycle() * info.getTime() + 10;
            stringRedisTemplate.opsForValue().set(k, v, expire, TimeUnit.SECONDS);
        } else {
            stringRedisTemplate.opsForValue().increment(k, var1);
        }

        Double var2 = Double.valueOf(stringRedisTemplate.opsForValue().get(k));
        Double avg = var2 / info.getCycle();
        if (avg >= threshold) {
            emailSender.send(Global.monitorTitle,
                    "sadwedwd",
                    info.getEmail());
            stringRedisTemplate.delete(k);
            record(info);
        }
    }

    /**
      * 报警记录持久化到 MySQL
     */
    private void record(MonitorInfo info) {
        MonitorRecord record = new MonitorRecord();
        record.setId(info.getId());
        record.setIndex(info.getIndex());
        record.setThreshold(info.getThreshold());
        record.setUsername(info.getUsername());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        record.setDatetime(format.format(new Date()));
        recordMapper.insertMonitorRecord(record);
    }
}
