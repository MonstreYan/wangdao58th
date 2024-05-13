package com.cskaoyan.th58.processor;

import com.cskaoyan.th58.util.ProxyUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 15:27
 * @Version 1.0
 */
@Component
public class ServiceEnhancerProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //针对userServiceImpl进行增强
        if(beanName.endsWith("ServiceImpl")){
            //对其进行增强
           bean = ProxyUtils.getProxy(bean);
        }
        return bean;
    }
}
