package com.cskaoyan.th58.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    public static void main(String[] args) {
        //提供三个参数：1.加载委托类对象的类加载器  2.委托类对象实现的接口  3.要求提供一个InvocationHandler:代理策略，究竟应该如何去行使代理功能
        //委托类
        UserService userService = new UserServiceImpl();
        UserService proxyInstance = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), new InvocationHandler() {
            //当前invoke方法其实就是指的是代理类对象如何去发挥代理功能的逻辑
            //需要做的事情便是进一步去调用委托类的代码
            //这个invoke方法 代理类对象会调用；代理类对象需要在内部进一步去调用委托类对象才可以

            //第一个参数：proxy表示的是代理类对象
            //第二个参数：method表示的是代理类对象中正在执行的方法的名称
            //第三个参数：args表示的是method执行的时候需要传递的参数
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println(method.getName() + " invoke before");
                //进一步去调用委托类的代码.方法的返回结果便是指的是当前方法的返回值
                Object invoke = method.invoke(userService, args);
                System.out.println(method.getName() + " invoke after");
                return invoke;
            }
        });

        //所以，无论是代理类对象的addUser updateUser deleteUser，均是调用的是invocationHandler.invoke()
        proxyInstance.addUser();

        proxyInstance.updateUser();

        proxyInstance.deleteUser();


        while (true){}
    }
}
