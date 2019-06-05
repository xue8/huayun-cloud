package cn.ddnd.huayun.es.ioc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @program: huayun
 * @description: ioc容器工具类
 * @author: Xue 8
 * @create: 2019-05-23 14:00
 **/

@Component
public class ApplicationUtil implements ApplicationContextAware {

    static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
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
