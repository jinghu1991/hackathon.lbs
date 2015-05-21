package com.sankuai.hackathon.lbs.framework.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Description: SpringContext
 * Author: liuzhao
 * Create: 2015-02-18 09:35
 */
@Component
public class SpringContext implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static <T> T getBean(String beanName, Class<T> classType) {
        return context.getBean(beanName, classType);
    }

    public static <T> T getBean(Class<T> classType) {
        return context.getBean(classType);
    }
}
