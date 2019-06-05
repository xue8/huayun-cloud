package cn.ddnd.huayun.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    DataSource dataSource;

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean()
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    //    开启驼峰命名
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
