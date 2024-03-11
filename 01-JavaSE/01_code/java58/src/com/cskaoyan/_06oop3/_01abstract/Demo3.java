package com.cskaoyan._06oop3._01abstract;

/**
 * 3.1. 成员特点
 * 1. 普通成员
 * 2. 静态成员
 * 3. 抽象方法
 *
 * 只要在普通类中能写的，在抽象类中，也可以写。
 * 它只是加了个东西。 只是加了一个抽象方法，抽象方法可以没有方法体。
 *
 * @author Common-zhou
 * @since 2024-03-11 17:38
 */
public class Demo3 {
    public static void main(String[] args) {
        // 现在，抽象类，又不能实例化，为啥有构造方法？
        // AbstractPerson3 abstractPerson3 = new AbstractPerson3(10);

        // 等会可以给子类用。
    }
}

// 在抽象类里面，普通成员（成员变量、成员方法）可以定义
// 静态成员（静态成员变量、静态成员方法）可以定义
// 构造方法： 也允许定义。
abstract class AbstractPerson3 {
    int i = 0;
    static int j = 2;

    public AbstractPerson3(int i) {
        this.i = i;
    }

    public void test1() {
        System.out.println("11111111");
    }

    public static void test2() {

    }
}
