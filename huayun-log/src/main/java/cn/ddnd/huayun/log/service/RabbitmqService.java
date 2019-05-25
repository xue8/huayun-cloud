package cn.ddnd.huayun.log.service;

import java.util.Map;

public interface RabbitmqService {
    void publish(Map message);
}
