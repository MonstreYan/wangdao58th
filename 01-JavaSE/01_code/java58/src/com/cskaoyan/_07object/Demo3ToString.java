package com.cskaoyan._07object;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-15 10:58
 */
public class Demo3ToString {

    @Test
    public void test1() {
        // 调用toString， 分两种情况
        // 1.如果子类中，没有重写该方法。则直接使用Object类中的toString方法
        // 2.如果子类中，重写了该方法，就用重写的方法 ===> 方法的覆盖

        Demo3ToString demo3ToString = new Demo3ToString();

        System.out.println(demo3ToString);

    }

    @Override
    public String toString() {
        return "123456";
    }

    @Test
    public void test2() {
        // 一般情况下，我们不关心  全限定类名 + 地址。
        // 所以官方推荐你重写掉它。
        // 重写一般没有固定格式，但是我们推荐大家，尽量打印出里面成员变量的取值。
        // 最好把类型也简单打印一下。

        Student3 student3 = new Student3(1, "景天", 40);

        System.out.println(student3);
        // 一定要注意。 打印的时候，一定是调用的toString方法。
    }
}


class Student3 {

    int id;
    String name;
    int age;

    public Student3(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // @Override
    // public String toString() {
    //     // String s = "Student3{" + id + name + age;
    //     String s = "Student3{id=" + id + ", name=" + name + ", age=" + age + "}";
    //
    //     return s;
    // }


    @Override
    public String toString() {
        return "Student3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
