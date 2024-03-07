package com.cskaoyan._04oop1._12block;

/**
 * ctrl + f 搜索
 * ctrl + r 搜索并替换
 *
 * @author Common-zhou
 * @since 2024-03-07 16:02
 */
public class Demo7 {
    // 静态代码块： 在类加载的时候执行一次。 且仅执行一次。
    static {
        System.out.println("Demo7类开始初始化步骤了!");
    }

    // 静态成员变量
    static Cat5 cat5 = new Cat5();
    Dog5 dog5 = new Dog5();
    public Demo7() {
        System.out.println("Demo7 constructor");
    }
    public static void main(String[] args) {
        System.out.println("hello world!");
        Demo7 d = new Demo7();
    }
}

class Cat5 {
    static {
        System.out.println("Cat5类开始初始化步骤了!");
    }

    static Dog5 dog5 = new Dog5();

    public Cat5() {
        System.out.println("Cat5  constructor");
    }
}

class Dog5 {
    static {
        System.out.println("Dog5类开始初始化步骤了!");
    }
    static Demo7 demo7 = new Demo7();
    public Dog5() {
        System.out.println("Dog5  constructor");
    }
}
