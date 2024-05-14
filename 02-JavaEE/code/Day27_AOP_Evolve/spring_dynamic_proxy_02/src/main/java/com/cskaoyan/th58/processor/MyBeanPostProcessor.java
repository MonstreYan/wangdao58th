package com.cskaoyan.th58.processor;

import com.cskaoyan.th58.util.ProxyUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 11:54
 * @Version 1.0
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //创建出来的bean对象，还没有放入到spring容器中，会被beanPostProcessor所处理
        //所以可以在此处进行狸猫换太子
        //其实并没有明显的提升，只是把proxy动态代理和spring加以整合
        Object proxy = ProxyUtils.getProxy(bean);
        return proxy;
    }
}
