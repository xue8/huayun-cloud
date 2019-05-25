package cn.ddnd.huayun.es.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @program: huayun
 * @description: ioc容器工具类
 * @author: Xue 8
 * @create: 2019-05-23 14:00
 **/

@Configuration
public class ApplicationUtil {

    static ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationUtil.applicationContext = applicationContext;
    }

    public static Object getBean(String name) {
       return applicationContext.getBean(name);
    }

    public static Object getBean(Class c) {
        return applicationContext.getBean(c);
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
