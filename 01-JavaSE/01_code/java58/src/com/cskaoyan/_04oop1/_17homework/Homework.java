package com.cskaoyan._04oop1._17homework;

public class Homework {
    static Student s = new Student();

    /*static*/ {
        System.out.println("Homework building");
        s = null;
    }


    public static void main(String[] args) {
        System.out.println("main");
        // 注释1
        System.out.println(s.age);
        Person p = new Person("刘备");
        System.out.println(p.name);
    }

    public Homework() {
        System.out.println("Homework constructor");
    }
}

class Person {
    {
        name = "赵云";
        System.out.println("Person building");
    }

    String name = "曹操";
    static Student s = new Student();

    public Person() {
    }

    public Person(String name) {
        System.out.println("Person constructor");
        this.name = name;
    }
}

class Student {
    int age = 10;

    {
        System.out.println("Student building");
        age = 20;
    }

    public Student(int age) {
        this.age = age;
    }

    public Student() {
        System.out.println("Student constructor");
    }
}
