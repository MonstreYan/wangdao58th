package com.cskaoyan.th58.aspect;

import com.cskaoyan.th58.domain.Log;
import com.cskaoyan.th58.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/15 9:44
 * @Version 1.0
 */
@Component
@Aspect
public class LogAspect {

    //直接去复用serivce的逻辑
    @Autowired
    LogService logService;

    @Pointcut("@annotation(com.cskaoyan.th58.annotation.Log)")
    public void pt(){}

    //设置什么通知？？？？？ 后置通知  异常通知

    @AfterReturning("pt()")
    public void success(JoinPoint joinPoint){
        //operation_method:  AdminService.addOne()
        //准备operation_method的值
        Object target = joinPoint.getTarget();
        String methodName = joinPoint.getSignature().getName();
        String operationMethod = target.toString() + "." + methodName;

        Log log = new Log(null, operationMethod, null, 1, null);
        logService.addLog(log);
    }

    @AfterThrowing(value = "pt()",throwing = "exp")
    public void error(JoinPoint joinPoint, Exception exp){
        Object target = joinPoint.getTarget();
        String methodName = joinPoint.getSignature().getName();
        String operationMethod = target.toString() + "." + methodName;
        Log log = new Log(null, operationMethod, null, 0, exp.toString());
        logService.addLog(log);

    }
}
