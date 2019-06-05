package cn.ddnd.huayun.web.ioc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

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

    public static String[] a(Class c) {
        String[] strings  = applicationContext.getBeanNamesForType(c);
        return strings;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
