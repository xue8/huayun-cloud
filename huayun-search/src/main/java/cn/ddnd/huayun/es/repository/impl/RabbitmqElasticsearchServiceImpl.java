package cn.ddnd.huayun.es.repository.impl;

import cn.ddnd.huayun.es.service.ElasticsearchService;
import cn.ddnd.huayun.es.repository.RabbitmqService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RabbitmqElasticsearchServiceImpl implements RabbitmqService {

    @Autowired
    ElasticsearchService elasticsearchDao;

    /**
     * 监听 rabbitMQ，获取消息
     * @param message
     */
    @RabbitListener(queues = "huayun.es")
    @Override
    public void consumer(Map message) {
        Map<String, String> map = message;
        String index = map.get("index");
        String type = map.get("type");
        map.remove("index");
        map.remove("type");
        elasticsearchDao.addDocument(index + "_" + type, "_doc", map);
    }
}
