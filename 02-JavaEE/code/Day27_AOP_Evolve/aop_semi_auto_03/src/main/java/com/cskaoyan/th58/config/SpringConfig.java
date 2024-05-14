package com.cskaoyan.th58.config;

import com.cskaoyan.th58.service.UserService;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 14:33
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.cskaoyan.th58")
public class SpringConfig {

    //借助于一个proxyFactorybean对象----可以生成一个代理类对象，无需开发人员自行去编写beanPostProcessor
    @Bean
    public ProxyFactoryBean userServiceProxy(UserService userService){
        ProxyFactoryBean factoryBean = new ProxyFactoryBean();
        //一个是关联通知
        factoryBean.setInterceptorNames("logAdvice");
        //一个是关联委托类对象
        factoryBean.setTarget(userService);
        return factoryBean;
    }

}
