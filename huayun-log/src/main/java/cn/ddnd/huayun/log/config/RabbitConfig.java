package cn.ddnd.huayun.log.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: huayun
 * @description: 序列化机制
 * @author: Xue 8
 * @create: 2019-05-21 15:30
 **/
@Configuration
public class RabbitConfig {

    /**
      * Json 格式序列化
     */
    @Bean
    public MessageConverter messageConverter() {
        MessageConverter messageConverter = new Jackson2JsonMessageConverter();
        return messageConverter;
    }
}
