package cn.ddnd.huayun.web;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "cn.ddnd.huayun.web")
@EnableDubbo
@EnableCaching
@EnableAspectJAutoProxy
@EnableScheduling
@EnableRabbit
public class HuayunWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuayunWebApplication.class, args);
    }

}
