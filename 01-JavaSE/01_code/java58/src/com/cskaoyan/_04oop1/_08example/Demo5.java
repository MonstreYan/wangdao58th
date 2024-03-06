package com.cskaoyan._04oop1._08example;

/**
 * Demo5这个叫不叫类？
 * 现在学习的类，都用来存储数据
 * 之前的类，都用来写方法。
 * 两个不同的功能而已。
 */
public class Demo5 {
    public static void main(String[] args) {
        // 灰色就是提示。
        Student s = new Student(18, "长风");
        System.out.println(s.age);
        System.out.println(s.name);
        System.out.println(s.var);
        System.out.println(s.cat.price);
    }
}

class Student {
    int age = 10;
    String name = "张三";
    double var = 20;

    public Student() {
    }
    public Student(int age) {
        System.out.println("Student age");
        this.age = age;
    }

    public Student(int age, String name) {
        this(age);
        System.out.println("Student age,name");
        this.name = name;
    }

    Cat cat = new Cat(1000);
    Cat c2;
}

class Cat {
    double price;

    public Cat() {
    }

    public Cat(double price) {
        System.out.println("Cat price");
        this.price = price;
    }
}
