package cn.ddnd.huayun.web;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableDubbo
@EnableCaching
@EnableAspectJAutoProxy
public class HuayunWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuayunWebApplication.class, args);
    }

}
