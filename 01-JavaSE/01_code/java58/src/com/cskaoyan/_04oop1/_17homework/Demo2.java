package com.cskaoyan._04oop1._17homework;
public class Demo2 {
    static {
        System.out.println("Demo2类开始初始化步骤了!");
    }
    static Cat2 cat5 = new Cat2();
    Dog2 dog2 = new Dog2();

    public Demo2() {
        System.out.println("Demo2 constructor");
    }

    public static void main(String[] args) {
        System.out.println("hello world!");
        Demo2 d = new Demo2();
    }
}

class Cat2 {
    static {
        System.out.println("Cat2类开始初始化步骤了!");
    }
    static Dog2 Dog2 = new Dog2();
    public Cat2() {
        System.out.println("Cat2  constructor");
    }
}

class Dog2 {
    static {
        System.out.println("Dog2类开始初始化步骤了!");
    }
    public Dog2() {
        System.out.println("Dog2  constructor");
    }
}

