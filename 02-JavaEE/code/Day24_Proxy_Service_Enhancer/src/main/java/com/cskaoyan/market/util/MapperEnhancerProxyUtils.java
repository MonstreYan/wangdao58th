package com.cskaoyan.market.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/10 14:59
 * @Version 1.0
 */
public class MapperEnhancerProxyUtils {

    public static Object getProxyInstance(Object target) {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


                //代理类对象的方法在调用时，都会进一步去调用委托类里面的同名方法
                //我们需要做的事情便是在controller中调用代理类对象的list、addGoods方法
                //代理类对象的该方法运行时，会进一步去调用委托类的同名方法，我们编写的业务逻辑是在委托类中的，增强逻辑是在代理类中的

                //在前面获取session
                SqlSession session = MybatisUtils.getSession();

                //委托类方法的调用
                Object invoke = null;
                try {
                    //给mapper进行赋值需要再前面进行
                    //首先需要获取委托类对象，获取委托类对象里面的成员变量
                    Class<?> aClass = target.getClass();
                    //拿到所有的成员变量
                    Field[] fields = aClass.getDeclaredFields();
                    for (Field field : fields) {
                        //只要确认成员变量是一个mapper，那么就对其进行赋值操作
                        if(field.getName().endsWith("Mapper")){
                            //成员变量的名称以mapper结尾，我们认为他就是一个mapper
                            //field成员变量有可能是private的，所以设置暴力访问
                            field.setAccessible(true);
                            //给哪个对象里面的成员变量来进行赋值，赋何值
                            Object mapper = session.getMapper(field.getType());
                            field.set(target, mapper);
                        }
                    }
                    invoke = method.invoke(target, args);
                    session.commit();
                }catch (Exception e){
                    session.rollback();
                    e.printStackTrace();
                }finally {
                    session.close();
                }

                //后面session提交、关闭
                return invoke;
            }
        });
    }
}
