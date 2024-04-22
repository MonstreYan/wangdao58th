package com.cskaoyan.th58.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtils {

    //target：委托类
    //proxy:代理类
    public static Object getProxyInstance(Object target){
       return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {

           //invoke方法会在代理类对象的方法调用时调用
           @Override
           public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

               System.out.println("before");
               //代理类对象调用invoke方法；我们需要做的事情便是在invoke方法内部进一步去调用委托类的同名方法，便是增强
               Object invoke = method.invoke(target, args);
               System.out.println("after");

               return invoke;
           }
       });
    }
}
