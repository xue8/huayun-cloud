package cn.ddnd.huayun.web.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
