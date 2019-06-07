package cn.ddnd.huayun.log.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationUtil  implements ApplicationContextAware {

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
