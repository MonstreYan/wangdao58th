package com.cskaoyan.th58.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/15 10:06
 * @Version 1.0
 */
@Component
@Aspect
public class TxAspect {

    @Autowired
    TransactionTemplate transactionTemplate;


    @Pointcut("@annotation(com.cskaoyan.th58.annotation.TX)")
    public void pt(){}


    //什么通知？？？？
    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint){
        //表示的是委托类方法的执行
        Object result = transactionTemplate.execute(new TransactionCallback<Object>() {

            @Override
            public Object doInTransaction(TransactionStatus status) {
                Object proceed = null;
                try {
                    proceed = joinPoint.proceed();
                } catch (Throwable e) {
                    e.printStackTrace();
//                    transactionTemplate.getTransactionManager().rollback(status);
                    //要不抛出一个运行时异常，要么自己去回滚
                    throw new RuntimeException(e);
                }

                return proceed;
            }
        });
        return result;
    }
}
