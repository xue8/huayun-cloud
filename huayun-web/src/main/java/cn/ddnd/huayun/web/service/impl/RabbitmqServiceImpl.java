package cn.ddnd.huayun.web.service.impl;

import cn.ddnd.huayun.web.config.Global;
import cn.ddnd.huayun.web.service.RabbitmqService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RabbitmqServiceImpl implements RabbitmqService {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void publish(Map message) {
        System.out.println(message);
        rabbitTemplate.convertAndSend(Global.exchange, Global.routingkey, message);
    }

}

