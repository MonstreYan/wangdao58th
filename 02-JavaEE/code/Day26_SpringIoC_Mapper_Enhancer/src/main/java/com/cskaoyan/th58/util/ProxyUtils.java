package com.cskaoyan.th58.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 15:20
 * @Version 1.0
 */
public class ProxyUtils {

    public static Object getProxy(Object target){
        Class<?> targetClass = target.getClass();
        return Proxy.newProxyInstance(targetClass.getClassLoader(), targetClass.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //代理类对象的方法调用时，都会调用invocationHandler.invoke方法
                //所以我们需要做的事情便是进一步去调用委托类的方法
                String methodName = method.getName();
//                if(methodName.equals("xxx")){
//                    enhancer1();
//                }else if(methodName.equals("yyy")){
//                    enhancer2();
//                }
                SqlSession sqlSession = MybatisUtils.getSqlSession();
                //应该给mapper去赋值
                //需要拿到当前委托类的成员变量
                Field[] fields = targetClass.getDeclaredFields();
                for (Field field : fields) {
                    if(field.getName().endsWith("Mapper")){
                        //认为它是一个mapper
                        field.setAccessible(true);
                        Object mapper = sqlSession.getMapper(field.getType());
                        //赋值
                        field.set(target, mapper);
                    }
                }

                Object invoke = method.invoke(target, args);

                sqlSession.commit();
                sqlSession.close();
                return invoke;
            }
        });
    }
}
