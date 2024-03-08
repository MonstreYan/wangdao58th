package com.cskaoyan._04oop1._17homework;

/**
 * debug一下也可以。
 */
public class Demo3 {
    static {
        System.out.println("Demo3类开始初始化步骤了!");
    }
    static Cat3 cat3 = new Cat3();
    Dog3 dog3 = new Dog3();
    public Demo3() {
        System.out.println("Demo3 constructor");
    }

    public static void main(String[] args) {
        System.out.println("hello world!");
        Demo3 d = new Demo3();
    }
}

class Cat3 {
    static {
        System.out.println("Cat3类开始初始化步骤了!");
    }
    static Dog3 dog3 = new Dog3();
    public Cat3() {
        System.out.println("Cat3  constructor");
    }
}

class Dog3 {
    static {
        System.out.println("Dog3类开始初始化步骤了!");
    }
    static Demo3 demo = new Demo3();
    public Dog3() {
        System.out.println("Dog3  constructor");
    }
}
