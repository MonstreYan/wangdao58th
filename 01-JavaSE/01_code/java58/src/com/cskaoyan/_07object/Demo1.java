package com.cskaoyan._07object;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * getClass()
 *
 * @author Common-zhou
 * @since 2024-03-15 09:48
 */
public class Demo1 {
    public int age;
    public String name;
    private int age1;

    public static void main(String[] args) {
        Object object = new Object();

        object.getClass();
    }


    @Test
    public void test1() {
        // Class对象是什么东西
        // JVM需要通过类加载，完成对某个类的认识。
        // 类加载后，想知道哪些信息？
        // 方法需要知道； 变量； 类名；
        // JVM需要全方位了解。
        // Class对象，就是JVM在类加载之后，帮你生成的一个对象。
        // 这个对象上，有这些所有的信息。

        Object o = new Object();
        Class<?> aClass = o.getClass();
        // 一个对象： 封装了Object的所有类型信息。

        // aClass.getDeclaredField();
        // aClass.getConstructors();
        // aClass.getMethod();

        // Class对象，就是JVM将这个类的类型信息，全部存储起来的一个对象。

        // Demo1 .--->  Demo1的Class对象。

        Demo1 demo1 = new Demo1();
        Class aClass1 = demo1.getClass();
        Field[] fields = aClass1.getFields();

        for (Field field : fields) {
            System.out.println(field);
        }
    }

    @Test
    public void test2() {
        // Class对象，就是JVM用来封装你的信息的。 比如封装Demo1里面，有哪些方法，有哪些属性，有哪些构造方法

        // getClass()方法只是获取Class对象，该方法不负责创建Class对象。
        // 正确来说，某个类的Class对象是JVM在类加载某个类的同时，在堆上创建的，Class对象是JVM创建的。

        // 某个类的类加载在一次程序运行过程中，仅有一次。
        // 所以某个类的运行时类对象（Class对象）也必然是唯一的！！
        // 相对应的，不同类型的两个类，它们的Class对象必然是两个不同的独立对象。

        // 所对应的类是一样的。 所以对应的Class是一个
        Demo1 demo1 = new Demo1();
        Demo1 demo11 = new Demo1();

        System.out.println(demo1.getClass() == demo1.getClass());
        System.out.println(demo1.getClass() == demo11.getClass());

        Object o = new Object();


        System.out.println(demo1.getClass() == o.getClass());

    }


    @Test
    public void test3() {
        // getClass一般在判断两个引用，是否是同种类型的时候使用。
        Demo1 demo1 = new Demo1();
        Demo1 demo2 = new Demo1();

        Object o = new Object();

        System.out.println("judgeType(demo1, o) = " + judgeType(demo1, o));
        System.out.println("judgeType(demo1, demo2) = " + judgeType(demo1, demo2));
    }

    @Test
    public void test4() {
        Demo1Son demo1Son = new Demo1Son();

        Demo1 demo1 = new Demo1Son();

        System.out.println("judgeType(demo1Son, demo1) = " + judgeType(demo1Son, demo1));

    }

    public static boolean judgeType(Object source, Object target) {
        // 多态
        return source.getClass() == target.getClass();
    }


}


class Demo1Son extends Demo1 {
}
