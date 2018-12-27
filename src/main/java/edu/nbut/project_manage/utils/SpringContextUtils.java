package edu.nbut.project_manage.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 普通类获取Spring容器中的bean
 */
public class SpringContextUtils implements ApplicationContextAware {
    private static ApplicationContext context;


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
