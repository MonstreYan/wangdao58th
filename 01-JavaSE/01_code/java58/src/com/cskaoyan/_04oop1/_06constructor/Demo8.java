package com.cskaoyan._04oop1._06constructor;

/**
 * @author Common-zhou
 * @since 2024-03-05 16:32
 */
public class Demo8 {
    public static void main(String[] args) {
        // 创建Person对象,成员变量的值分别是什么
        Person p = new Person("张三", 30);

        // 现在  p中变量的值， 是什么
        System.out.println("p.name = " + p.name);

        System.out.println("p.age = " + p.age);
    }
}

class Person {
    public String name;
    public int age = 20;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
