package cn.ddnd.huayun.log;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableRabbit
@EnableScheduling
public class LogCollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogCollectionApplication.class, args);
    }

}
