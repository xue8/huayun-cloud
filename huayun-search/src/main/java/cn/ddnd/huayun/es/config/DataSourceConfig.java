package cn.ddnd.huayun.es.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @program: huayun
 * @description: 数据源配置
 * @author: Xue 8
 * @create: 2019-05-23 18:48
 **/
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


//    配置druid的监控
//    添加自定义的serlvet到Spring容器中
//    StatViewServlet这个servlet是druid提供的监控管理系统
//    @Bean
//    public ServletRegistrationBean statViewServlet() {
//        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet());
//        Map map = new HashMap();
//        map.put("jmxUsername", "admin");
//        map.put("jmxPassword", "admin");
//        map.put("jmxUrl", "jmx");
//        bean.setInitParameters(map);
//        return bean;
//    }
//
////    配置监控的filter
//    @Bean
//    public FilterRegistrationBean webStatFilter() {
//        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
//        bean.setUrlPatterns(Arrays.asList("/*"));
//        return bean;
//    }
}
