package com.cskaoyan.th58.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 17:42
 * @Version 1.0
 */
//注册为spring容器中的一个组件
@Component
//编写的是一个切面，所以需要额外添加一个aspect注解
@Aspect
public class LogAspect {
    //切面 = 切入点(匹配连接点的过程 execution) + 通知(增强)


    //新建一个空的方法，修饰符public，返回值void
    //这里面只会去取当前方法的名称作为当前切入点的编号 ------GoodsServiceImpl.addOne ------beforeAdvice
    @Pointcut("execution(* com.cskaoyan..service.*ServiceImpl.add*(..))")
    public void pt1(){}


    //before注解就表示的是当前是一个前置通知
    @Before("pt1()")
    public void beforeAdvice(){
        System.out.println("前置通知");
    }
}
