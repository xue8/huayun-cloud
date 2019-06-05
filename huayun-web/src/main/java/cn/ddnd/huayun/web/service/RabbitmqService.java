package cn.ddnd.huayun.web.service;

import java.util.Map;

public interface RabbitmqService {
    void publish(Map message);
}
