package com.cskaoyan.th58.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StudentReflect {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        //反射：
        //new是一个关键字，Student()是不是构造函数？是；主动地调用了无参构造函数，将创建好的实例对象的地址赋值给参数student
        //Student student = new Student();

        //使用反射第一步，那么便是获取Class对象；如何获取Class对象呢？
        //1.对象.getClass  2.类.class
        Class<Student> studentClass = Student.class;

        Object object = null;
        //这里面获取的是全部的构造函数
        Constructor<?>[] constructors = studentClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if(constructor.getParameterCount() == 0){
                //无参构造函数
                object = constructor.newInstance();
            }
        }

        //获取的是当前类里面的全部的属性 包含私有的
        Field[] fields = studentClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String simpleName = field.getType().getSimpleName();
            if(simpleName.equals("String")){
                field.set(object, "kongling");
            }else if(simpleName.equals("Integer")){
                field.set(object, 28);
            }
            //暴力破解，如果field是私有的，则需要写这行代码才可以进行赋值操作
            //表示的是给哪个对象中的当前属性进行赋值，赋何值
        }

        //获取的是当前类里面的全部的方法 包含私有的
        Method[] methods = studentClass.getDeclaredMethods();
        for (Method method : methods) {
            //调用该方法
            if(method.getName().equals("setName")){
                method.invoke(object, "空灵");
            }
        }


        System.out.println(object);
    }
}
