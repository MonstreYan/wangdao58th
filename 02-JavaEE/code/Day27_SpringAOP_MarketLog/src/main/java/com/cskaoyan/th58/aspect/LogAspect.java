package com.cskaoyan.th58.aspect;

import com.cskaoyan.th58.annotation.Log;
import com.cskaoyan.th58.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 11:11
 * @Version 1.0
 */
@Component
@Aspect
public class LogAspect {

    //spring会自动帮你进入注入
    @Autowired
    LogService logService;

    @Pointcut("@annotation(com.cskaoyan.th58.annotation.Log)")
    public void pt(){}


    //接收结果通知
    @AfterReturning(value = "pt()", returning = "result")
    public void result(JoinPoint joinPoint, Object result){
        //获取当前方法上面的Log注解里面的type以及action的值
        //如何获取注解里面的值呢？借助于反射 Class

        //拿到委托类对象
        Object target = joinPoint.getTarget();
        //获取委托类对象对应的Class对象信息
        Class<?> targetClass = target.getClass();

        //joinPoint就是对于当前运行的方法的封装体，里面会包含方法的信息
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        //因为目前我们这是一个方法，所以可以强转成MethodSignature
        MethodSignature methodSignature = (MethodSignature) signature;

        Class<?>[] parameterTypes = methodSignature.getMethod().getParameterTypes();
        //拿到方法:java语言里面允许方法同名，定位一个方法不仅需要方法的名称，还需要参数签名，也就是参数类型
        Method method = null;
        try {
            method = targetClass.getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        Log log = method.getAnnotation(Log.class);
        String type = log.type();
        String action = log.action();
        System.out.println(type + ":" + action);
        logService.addLog();
    }
}
