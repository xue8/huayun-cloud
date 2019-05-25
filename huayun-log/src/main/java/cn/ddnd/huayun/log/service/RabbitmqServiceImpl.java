package cn.ddnd.huayun.log.service;

import cn.ddnd.huayun.log.config.Global;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: huayun
 * @description: 日志发布到 rabbitmq
 * @author: Xue 8
 * @create: 2019-05-22 16:16
 **/
@Service
public class RabbitmqServiceImpl implements RabbitmqService{
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void publish(Map message) {
        System.out.println(message);
        rabbitTemplate.convertAndSend(Global.exchange, Global.routingkey, message);
    }

}
