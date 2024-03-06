package com.cskaoyan._04oop1._07debug;

/**
 * @author Common-zhou
 * @since 2024-03-05 20:56
 */
public class Demo4 {
    public static void main(String[] args) {
        // 说明一下，
        // 默认初始化、显式赋值、构造方法的执行顺序。
        // 无论什么赋值方式，永远是默认初始化在第一步。
        Student stu = new Student(18, "王冰冰");
    }
}

class Student {
    int age = 10;
    String name = "张三";
    double a = 100;

    public Student() {
    }

    public Student(int age) {
        System.out.println("Student age");
        this.age = age;
    }

    public Student(int age, String name) {
        this(age);
        System.out.println("Student age，name");
        this.name = name;
    }
}
