package cn.ddnd.huayun.log.service;

import cn.ddnd.huayun.log.config.Global;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RabbitmqServiceImpl implements RabbitmqService{
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * rabbitmq 消息发布
     * @param message
     */
    @Override
    public void publish(Map message) {
        System.out.println(message);
        rabbitTemplate.convertAndSend(Global.exchange, Global.routingkey, message);
    }

}
