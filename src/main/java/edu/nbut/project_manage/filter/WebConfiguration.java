package edu.nbut.project_manage.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfiguration {

/*
        implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        *//*
        除了该路径不过滤，其他URL都进行过滤
         *//*
        registry.addInterceptor(new MyHandlerInterceptor()).excludePathPatterns("/user/login");
    }*/
}
