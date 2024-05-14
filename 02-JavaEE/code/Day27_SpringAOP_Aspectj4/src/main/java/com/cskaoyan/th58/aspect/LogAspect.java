package com.cskaoyan.th58.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 10:19
 * @Version 1.0
 */
@Component
@Aspect
public class LogAspect {

    @Pointcut("@annotation(com.cskaoyan.th58.annotation.Log)")
    public void pt1(){}


    //说明：在开发过程中，没有场景需要把所有的通知都写一遍，我们这里面是给大家做演示
    //大家在开发过程中，需要选择一个合适的通知类型

    //通知 前置通知
    @Before("pt1()")
    public void beforeAdvice(JoinPoint joinPoint){
        //获取委托类信息
        Object target = joinPoint.getTarget();
        //获取的是代理类对象信息
        Object aThis = joinPoint.getThis();
        //签名-----需要获取方法的信息，进行向下转型，转换成方法签名
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String name = methodSignature.getName();

        System.out.println("这是一个前置通知");
    }

    //后置通知
    @After("pt1()")
    public void afterAdvice(){
        System.out.println("这是一个后置通知");
    }

    //环绕通知比较特殊：返回值结果不可以是void，必须是object
    //对于混绕通知来说，需要去调用委托类的方法，必须要传递一个形参ProceedingJoinPoint
    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint){
        System.out.println("这是环绕通知前");
        //调用委托类的方法
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println("这是环绕通知后");
        return proceed;
    }

    //异常通知
    //当发生异常时，会把异常的信息，赋值给当前的通知中的形参exp
    @AfterThrowing(value = "pt1()",throwing = "exp")
    public void expAdvice(Exception exp){
        System.out.println("异常通知" + exp);
    }

    //返回结果通知:会把委托类方法的运行结果赋值给当前通知的形参result
    @AfterReturning(value = "pt1()", returning = "result")
    public void resultAdvice(Object result){
        System.out.println("接收结果通知：" + result);
    }
}
