package com.cskaoyan.th58.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 9:43
 * @Version 1.0
 */
//将其放入到spring容器中，声明它是一个组件对象
@Component
//告诉spring，这是一个切面，后续需要去解析当前类 切面 = 切入点(使用execution关联业务方法) + 通知(需要关联切入点编号)
@Aspect
public class LogAspect {

    //切入点
    //这里面的语法表示的含义是匹配com.cskaoyan包下的任意子包(只有一级)里面的service包里面的凡是以ServiceImpl结尾的类中以add方法开头的方法，对于方法的返回值没有要求；方法的参数类型也没有要求
    @Pointcut("execution(* com.cskaoyan.*.service.*ServiceImpl.add*(..))")
    public void pt1(){}


    //通知
    @Before("pt1()")
    public void beforeAdvice(){
        System.out.println("这是一个前置通知");
    }
}
