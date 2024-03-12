package com.cskaoyan._06oop3._02interface._06method;

/**
 * 方法的形参在方法调用传入实参时，不一定要求数据类型完全一致。
 * 基本类型：对于基本数据类型的方法形参，存在自动类型提升。（long num）  int
 * 引用类型： 对于引用数据类型的方法传参，存在自动向上转型。
 *
 * @author Common-zhou
 * @since 2024-03-12 15:07
 */
public class Demo1 {

    public static void main(String[] args) {
        test1(100);

        byte b = 12;
        double d = 1.0;

        test1(b);
        // test1(d);

        test2(10);
        // 自动类型转换： 从小范围转大范围。


        // 调用test3的时候，是否一定要传入一个 Animal的对象。
        // Dog1  Cat1行不行？

        // Dog1 is-a Animal1
        test3(new Cat1());
        test3(new Dog1());
    }

    public static void test1(int num) {
        System.out.println(num + 1);
    }

    public static void test2(double num) {
        System.out.println(num + 1);
    }

    // 需要引用数据类型
    public static void test3(Animal1 animal1) {
        // 现在，传入的是一个看起来是 Animal1的东西，实际对象是 Cat
        // animal1.test1();   ===> Cat 的方法
        // 多态
        animal1.test1();
    }
}


class Animal1 {
    void test1() {
        System.out.println("animal1 test");
    }
}

class Dog1 extends Animal1 {
    void test1() {
        System.out.println("Dog1 test");
    }
}

class Cat1 extends Animal1 {
    void test1() {
        System.out.println("Cat1 test");
    }
}
