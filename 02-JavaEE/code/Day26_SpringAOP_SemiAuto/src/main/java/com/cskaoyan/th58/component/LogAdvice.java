package com.cskaoyan.th58.component;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 16:44
 * @Version 1.0
 */
@Component
public class LogAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

//        MethodInvocation你可以理解为就是对于动态代理设计模式中的method的进一步封装
        //下面这行代码就是对于method.invoke()又做了进一层的封装，原理和之前是完全等价的 委托类方法的调用
        System.out.println("log before");
        Object proceed = invocation.proceed();
        System.out.println("log after");
        return proceed;
    }
}
