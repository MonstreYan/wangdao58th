package com.cskaoyan._05oop2._02extends._12final;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-11 14:50
 */
public class Demo5 {

    public void test1() {
        // final可以修饰 局部变量，也可以修饰成员变量
        // 先看一下局部变量。
        final int age = 10;

        // Cannot assign a value to final variable 'age': final用来修饰变量，不能修改。
        // age = 20;
        // final修饰变量，其他的没有区别。就是有一个区别，之前能修改，修饰后不能修改。

        System.out.println(age);
    }

    // @Test
    public void test2() {
        // 1.final修饰基本数据类型: 就是变量的值不允许修改。

        final int age = 10;
        // age = 20;

        // 2.final修饰引用数据类型： 引用的地址不能变，但是引用里面的内容。可以变
        final Student5 student5 = new Student5("zs", 18);

        System.out.println("student5.name = " + student5.name);
        System.out.println("student5.age = " + student5.age);

        // 这行代码，放出来后，编译有没有问题。  ==》 报错。
        // Cannot assign a value to final variable 'student5'
        // student5 = new Student5("ls", 20);

        // 报不报错？  ===》不报错
        student5.name = "zhangsan";
        System.out.println("student5.name = " + student5.name);
    }

    public static void main(String[] args) {
        Demo5 demo5 = new Demo5();
        demo5.test2();
    }
}

class Student5 {
    String name = "student5";
    int age = 20;

    public Student5(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
