package cn.ddnd.huayun.log.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OkHttp {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }
}
