package cn.ddnd.huayun.es.repository;

import java.util.Map;

public interface RabbitmqService {
    void consumer(Map message);
}
