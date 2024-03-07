package com.cskaoyan._04oop1._10static;

/**
 * 在工作过程中，这种执行顺序有没有用。
 * 没有。
 * 为什么要讲： 面试的时候，经常有这种题目。
 *
 *
 *
 * @author Common-zhou
 * @since 2024-03-07 14:47
 */
public class Demo12 {
    // 静态成员变量
    static Cat12 cat = new Cat12();
    Dog12 dog = new Dog12();
    Dog12 dog2;
    static Dog12 dog3;

    public Demo12() {
        System.out.println("demo init");
    }

    public static void main(String[] args) {
        System.out.println("hello world!Demo main");
        Demo12 d = new Demo12();
    }
}

class Cat12 {
    static Dog12 dog = new Dog12();

    // new Cat12()
    public Cat12() {
        System.out.println("cat init");
    }
}

class Dog12 {
    public Dog12() {
        System.out.println("dog init");
    }
}
