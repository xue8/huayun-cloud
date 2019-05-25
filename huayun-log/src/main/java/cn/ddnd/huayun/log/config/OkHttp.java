package cn.ddnd.huayun.log.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: huayun
 * @description: 配置 OkHttp客户端
 * @author: Xue 8
 * @create: 2019-05-22 16:32
 **/
@Configuration
public class OkHttp {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }
}
