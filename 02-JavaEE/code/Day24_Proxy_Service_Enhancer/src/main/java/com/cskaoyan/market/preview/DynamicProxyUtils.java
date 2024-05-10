package com.cskaoyan.market.preview;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/10 14:43
 * @Version 1.0
 */
public class DynamicProxyUtils {

    //里面需要获取加载委托类的类加载器、委托类实现的接口-----可以借助于Class对象来获取
    //第三个参数invocationHandler----传递给Proxy类内部的成员变量
    //代理类对象继承自Proxy类，所以内部也会持有invocationHandler
    //代理类对象的方法调用时，只会固定的调用invocationHandler.invoke(proxy, method, args);
    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //在前面进行一系列的处理
                //进一步去调用委托类的同名方法
                Object invoke = method.invoke(target, args);
                //在后面进行一系列的处理
                return invoke;
            }
        });
    }
}
