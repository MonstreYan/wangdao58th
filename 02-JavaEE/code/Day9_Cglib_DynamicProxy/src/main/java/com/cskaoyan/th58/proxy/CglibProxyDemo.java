package com.cskaoyan.th58.proxy;

import com.cskaoyan.th58.target.UserComponent;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyDemo {

    public static void main(String[] args) {
        //增强器，便是cglib中用来去创建代理类对象的
        Enhancer enhancer = new Enhancer();

        //为什么需要设置super class呢？cglib使用的是继承自委托类的方式来实现的
        UserComponent userComponent = new UserComponent();


        enhancer.setSuperclass(userComponent.getClass());

        //非常类似于invocationHandler的功能
        enhancer.setCallback(new MethodInterceptor() {

            //该方法便是代理类对方法调用时，会调用该方法
            //第一个参数：obj指的是代理类对象
            //第二个参数：method指的是当前代理类对象中正在执行的方法
            //第三个参数：args指的是代理类对象的方法运行时，传递的参数
            //第四个参数：一般是指的是代理类的方法
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

//                method.invoke(userComponent, args)
                //进一步去调用委托类的方法
                //这行代码的作用是通过调用代理类对象的方法，代理类对象的方法会进一步调用super也就是父类的同名方法
                System.out.println("before");
                //此处是直接调用了代理类的方法，因为代理的方法内部会进一步去调用super，也就是调用了委托类的同名方法
                Object o = proxy.invokeSuper(obj, args);
                System.out.println("after");
                return o;
            }
        });

        UserComponent proxy = (UserComponent) enhancer.create();
        proxy.function();
    }
}
