package com.cskaoyan._15reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Common-zhou
 * @since 2024-03-25 17:23
 */
public class Demo5Constructor {

    @Test
    public void test1GetConstructorAndDeclared() {
        // 获取User5的所有构造方法。 怎么获取

        // getConstructor

        // 调用这个方法的前提，一定是要先拿到Class对象。
        // getConstructor();
        Class<User5> user5Class = User5.class;

        // getConstructors
        // getDeclaredConstructors
        // 前者只拿public。 后者所有的都拿。(private  protected 默认)
        // 后续在见到  Declared .都是这种含义
        Constructor<?>[] constructors = user5Class.getConstructors();
        Constructor<?>[] declaredConstructors = user5Class.getDeclaredConstructors();

        System.out.println("getConstructors=====================================");
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("declaredConstructors====================================");
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

    }


    @Test
    public void test2GetMethod() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<User5> user5Class = User5.class;

        // 这个找不到，会报错。
        // Constructor<User5> constructor = user5Class.getConstructor();
        Constructor<User5> constructor = user5Class.getConstructor(String.class, String.class);
        System.out.println(constructor);

        User5 user5 = constructor.newInstance("zs", "hubei");

        System.out.println(user5);


        // user5Class.getDeclaredConstructor();
        Constructor<User5> constructor1 = user5Class.getDeclaredConstructor();

        System.out.println(constructor1);


    }


    @Test
    public void test3() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<User5> user5Class = User5.class;

        Constructor<User5> constructor1 = user5Class.getDeclaredConstructor();

        System.out.println(constructor1);

        // 如果是private 私有权限修饰的。 这个时候，new
        // 'User5()' has private access in 'com.cskaoyan._15reflect.User5'
        // User5 user5 = new User5();

        // 反射这里，提供了暴力破解的方式。即使你是private的。也可以new出来。
        // constructor1.setAccessible(true);  让可以访问。

        constructor1.setAccessible(true);
        User5 user5 = constructor1.newInstance();

        System.out.println(user5);

        // 防君子，防不住小人。
    }

    @Test
    public void test4() throws NoSuchMethodException {

        Class<User5> user5Class = User5.class;

        // 如果是个int。 拿的时候，需要通过 int.class拿
        // Constructor<User5> declaredConstructor = user5Class.getDeclaredConstructor(Integer.class);
        Constructor<User5> declaredConstructor = user5Class.getDeclaredConstructor(int.class);

        System.out.println(declaredConstructor);
    }
}

class User5 {
    String name;
    int age;

    String address;

    private User5() {
    }

    User5(String name) {
        this.name = name;
    }


    public User5(int age) {
        this.age = age;
    }

    protected User5(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User5(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public User5(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User5{" + "name='" + name + '\'' + ", age=" + age + ", address='" + address + '\'' + '}';
    }
}
