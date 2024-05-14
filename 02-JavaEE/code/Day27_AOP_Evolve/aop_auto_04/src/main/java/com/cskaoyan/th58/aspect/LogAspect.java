package com.cskaoyan.th58.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 14:40
 * @Version 1.0
 */
//设置为spring容器中的一个组件对象
@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(* com.cskaoyan.*.service.*ServiceImpl.add*(..))")
    public void pt(){}


    @Before("pt()")
    public void beforeAdvice(JoinPoint joinPoint){

    }
}

