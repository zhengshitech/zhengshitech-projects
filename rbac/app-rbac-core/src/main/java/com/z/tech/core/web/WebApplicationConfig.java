package com.z.tech.core.web;

import com.z.tech.core.exception.GlobalExceptionHandler;
import com.z.tech.core.json.MyMappingJackson2HttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.annotation.WebFilter;
import java.util.List;

/**
 * @author H
 */
@Configuration
//public class WebApplicationConfig extends WebMvcConfigurationSupport {
//public class WebApplicationConfig extends WebMvcConfigurerAdapter {
public class WebApplicationConfig implements WebMvcConfigurer {


    @Autowired
    private MyHandlerInterceptor myHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        String[] pathPatterns = {
                "/webapi/tenant/**"
        };

        //不需要拦截的
        String[] excludePathPatterns = {
                "/api/",
                "/api/hi",
        };

        InterceptorRegistration interceptorRegistration = registry.addInterceptor(myHandlerInterceptor)
                .addPathPatterns(pathPatterns)
                .excludePathPatterns(excludePathPatterns);
        System.out.println("注册拦截器成功:" + interceptorRegistration);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        boolean isRemove = converters.removeIf(x -> x instanceof MappingJackson2HttpMessageConverter);
        System.out.println("移除原始MappingJackson2HttpMessageConverter实例：" + isRemove);

        MyMappingJackson2HttpMessageConverter myConverter = new MyMappingJackson2HttpMessageConverter();
        converters.add(0, myConverter);
    }


    @Bean
    public MyHandlerInterceptor myHandlerInterceptor() {
        MyHandlerInterceptor myHandlerInterceptor = new MyHandlerInterceptor();
        System.out.println("###MyHandlerInterceptor inited:" + myHandlerInterceptor);
        return myHandlerInterceptor;
    }

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        System.out.println("###GlobalExceptionHandler inited:" + globalExceptionHandler);
        return globalExceptionHandler;
    }

    @Bean
    public FilterRegistrationBean filterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/webapi/tenant/*");
        registration.addInitParameter("test", "testValue222222");
        registration.setName("myFilter");
        registration.setOrder(1);
        return registration;
    }


}
