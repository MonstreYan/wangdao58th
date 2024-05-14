package com.cskaoyan.th58.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 14:35
 * @Version 1.0
 */
@Component
public class LogAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
    //对于委托类方法的调用
        Object proceed = invocation.proceed();

        return proceed;
    }
}
