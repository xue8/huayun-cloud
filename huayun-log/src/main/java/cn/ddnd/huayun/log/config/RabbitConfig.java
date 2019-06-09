package cn.ddnd.huayun.log.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
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

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("huayun.direct", true, false);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("huayun.fanout", true, false);
    }

    @Bean
    public Queue queueEs() {
        return new Queue("huayun.es", true,false, false, null);
    }

    @Bean
    public Queue queueMonitorInfo() {
        return new Queue("huayun.monitor.info", true,false, false, null);
    }

    @Bean
    public Queue queuePersistence() {
        return new Queue("huayun.persistence", true,false, false, null);
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queueEs()).to(fanoutExchange());
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queuePersistence()).to(fanoutExchange());
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(queueMonitorInfo()).to(directExchange()).with("huayun.monitor.info");
    }

}
