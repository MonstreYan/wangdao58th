package com.cskaoyan.th58.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 10:02
 * @Version 1.0
 */
@Component
@Aspect
public class LogAspect {


    //切入点 ----表达式关联的是一个自定义注解，只要哪个业务方法上面标注了该注解，那么便关联了当前的业务方法
    @Pointcut("@annotation(com.cskaoyan.th58.annotation.Log)")
    public void pt1(){}

    //通知通过切入点编号关联了切入点，进一步关联了业务方法
    @Before("pt1()")
    public void beforeAdvice(){
        System.out.println("这是一个前置通知");
    }
}
