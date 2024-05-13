package com.cskaoyan.th58.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 14:39
 * @Version 1.0
 * beanPostProcessor的功能非常像filter的功能，可以针对创建出来的其他的bean对象进行前置和后置处理
 * 至于究竟应该吧代码逻辑写在前置还是后置中，取决于你的bean对象有没有init逻辑，如果有init逻辑，并且处理的逻辑也要求和init有关，那么必须得使用后置
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    //前置处理
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean + "====" + beanName);
        //狸猫换太子，也就是说在进行前置处理之前呢，是委托类对象，经过处理之后变成了代理类对象，继续向后传递
        //这个便是AOP的理论基石
        return bean;
    }

    //后置处理
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
