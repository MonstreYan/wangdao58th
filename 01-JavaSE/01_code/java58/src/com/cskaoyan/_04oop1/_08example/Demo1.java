package com.cskaoyan._04oop1._08example;

/**
 * 用面向对象的思想模拟人和工作。人有一个工作，工作有工作名和工资。
 * 什么是类？ 模板。
 * 什么是对象？  根据这个模板创建出来的实例。
 * <p>
 * 人： 是一个类
 * 工作。
 *
 * 类在Java中是干什么的？  ===》 用通俗的话说出来。
 * 用来组织数据的。  它也是一种全新的数据类型（自定义的数据类型）
 *
 * 对象是干什么的？  ===》 对象是用来表示具体的数据的。
 *
 * @author Common-zhou
 * @since 2024-03-06 10:58
 */
public class Demo1 {
    public static void main(String[] args) {
        // 假设 一个叫做  zhangsan 的程序员  性别男。年龄20

        // 他有一份工作。  Java后端开发工程师，工资12000
        // 怎么表示？

        Person zhangsanPerson = new Person("zhangsan", "male", 20);

        Job job = new Job("Java后端开发工程师", 12000);

        zhangsanPerson.job = job;

        zhangsanPerson.showInfo();
    }
}

// 人名、性别、年龄
class Person {
    public String name;
    public String gender;
    public int age;

    // 人有一个工作。 在这怎么表现出来
    // 用变量的持有表示。 成员变量。
    // 用人持有一个Job。 表示，这个人的属性是这个，也即工作是这个。
    public Job job;

    // [权限修饰符] 类名(形参列表){}

    public Person() {
    }

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void showInfo() {
        System.out.println("人名：" + name + ", 性别：" + gender + "， 年龄: " + age);
        if (job != null) {
            System.out.println("这个人的工作名称：" + job.name + ", 薪资:" + job.salary);
        }
    }
}

class Job {
    // 工作名和工资。
    public String name;
    public int salary;

    public Job(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public Job() {
    }

}
