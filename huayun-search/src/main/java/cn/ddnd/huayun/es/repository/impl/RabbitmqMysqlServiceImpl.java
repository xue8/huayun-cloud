package cn.ddnd.huayun.es.repository.impl;

import cn.ddnd.huayun.es.mapper.CloudMapper;
import cn.ddnd.huayun.es.pojo.Cloud;
import cn.ddnd.huayun.es.repository.RabbitmqService;
import cn.ddnd.huayun.es.util.Util;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @program: huayun
 * @description: MySQL消费者
 * @author: Xue 8
 * @create: 2019-05-22 17:16
 **/

@Service
public class RabbitmqMysqlServiceImpl implements RabbitmqService {

    @Autowired
    CloudMapper cloudMapper;

    @RabbitListener(queues = "huayun.persistence")
    @Override
    public void consumer(Map message) {
        Map<String, Object> map = message;
        Cloud cloud = new Cloud();
        String datetime = (String) map.get("datetime");
        datetime = Util.UTCToCST(datetime);
        String unit = (String) map.get("unit");
        Double used = (Double) map.get("used");
        String username = (String) map.get("username");
        String id = (String) map.get("id");
        String index = (String) map.get("index");
        String type = (String) map.get("type");
        Integer interval = (Integer) map.get("interval");
        cloud.setDatetime(datetime);
        cloud.setUnit(unit);
        cloud.setUsed(used);
        cloud.setUsername(username);
        cloud.setCloudId(id);
        cloud.setInterval(interval);
        if (type.equals("cpu")) {
            cloudMapper.insertCloudCpu(cloud);
        } else if (type.equals("ram")) {
            cloudMapper.insertCloudRam(cloud);
        } else if (type.equals("io_read")) {
            cloud.setTag((String) map.get("tag"));
            cloudMapper.insertCloudIoRead(cloud);
        } else if (type.equals("io_write")) {
            cloud.setTag((String) map.get("tag"));
            cloudMapper.insertCloudIoWrite(cloud);
        } else if (type.equals("iops_read")) {
            cloud.setTag((String) map.get("tag"));
            cloudMapper.insertCloudIopsRead(cloud);
        } else if (type.equals("iops_write")) {
            cloud.setTag((String) map.get("tag"));
            cloudMapper.insertCloudIopsWrite(cloud);
        } else if (type.equals("fip_in")) {
            cloud.setTag((String) map.get("ip"));
            cloudMapper.insertCloudFipIn(cloud);
        } else if (type.equals("fip_out")) {
            cloud.setTag((String) map.get("ip"));
            cloudMapper.insertCloudFipOut(cloud);
        } else if (type.equals("disk_used")) {
            cloud.setTag((String) map.get("tag"));
            cloudMapper.insertCloudDiskUsed(cloud);
        }

    }
}