package com.cskaoyan.th58.config;

import com.cskaoyan.th58.service.GoodsService;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 16:32
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.cskaoyan.th58")
public class SpringConfig {

    //写@Bean注解的方式
    //需要关注一下这类有没有实现FactoryBean接口，如果实现了该接口，那么直接取出来的并不是该对象本身，而是getObject方法的返回值
    //因为ProxyFactoryBean实现了FactoryBean接口，所以注册到容器中，利用编号取出来的是getObject返回值，通过查看方法说明可以得知，返回的是一个proxy代理类对象
    //现在我需要对GoodsServiceImpl进行增强，所以需要借助于ProxyFactoryBean对于GoodsServiceImpl进行处理，产生代理类对象
    @Bean
    public ProxyFactoryBean goodsServiceProxy(GoodsService goodsService){
        ProxyFactoryBean bean = new ProxyFactoryBean();
        //设置委托类 GoodsService
        bean.setTarget(goodsService);
        //通知：何种增强-----日志打印
        //这里面直接设置通知类的编号即可关联在一起，为什么？？？？
        //因为ProxyFactoryBean实现了FactoryBean接口，内部持有容器的引用，可以利用容器.getBean(id)来获取指定的对象
        bean.setInterceptorNames("logAdvice");
        return bean;
    }
}
