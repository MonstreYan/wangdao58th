package com.cskaoyan._19collection._02introduct;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Common-zhou
 * @since 2024-03-28 17:42
 */
public class Demo1 {
    @Test
    public void test1() {
        // 集合是具有某种特定性质的事物的总体。 这里的“事物”可以是人，物品，也可以是数学元素。

        // 都叫集合。
        // Teacher[]
        // Student[]
        // String[]
    }


    @Test
    public void test2() {
        // 集合类就是Java里面提供的一套类。 帮助我们将数组的一些操作封装起来。让我们更方便的操作数据。

        // 1.班上有5个同学。  学生有名字，年龄，地址等信息
        Student[] students = new Student[5];
        students[0] = new Student("zs", 18, "hubei");
        students[1] = new Student("ls", 18, "hubei");
        students[2] = new Student("wu", 18, "hubei");
        students[3] = new Student("zl", 18, "hubei");
        students[4] = new Student("sq", 18, "hubei");

        // 2.现在转学走了一个同学(第三个同学)。  怎么表示
        // index = 2
        students[2] = students[3];
        students[3] = students[4];
        students[4] = null;

        // 3.新学期，又来了三个学生  怎么表示
        // 创建一个新的数数组。把原来的数据copy过去。 再把新来的加进去。

    }


    @Test
    public void test3() {
        // 1.班上有5个同学。  学生有名字，年龄，地址等信息
        Collection<Student> collection = new ArrayList<>();
        collection.add(new Student("zs", 18, "hubei"));
        collection.add(new Student("ls", 18, "hubei"));
        Student student = new Student("wu", 18, "hubei");
        collection.add(student);
        collection.add(new Student("zl", 18, "hubei"));
        collection.add(new Student("sq", 18, "hubei"));

        System.out.println(collection);

        // 2.现在转学走了一个同学(第三个同学)。  怎么表示
        collection.remove(student);
        System.out.println(collection);

        // 3.新学期，又来了三个学生  怎么表示

        collection.add(new Student("zl1", 18, "hubei"));
        collection.add(new Student("zl2", 18, "hubei"));
        collection.add(new Student("zl3", 18, "hubei"));
        System.out.println(collection);
    }

    @Test
    public void test4() {
        // 数组的长度。可不可能无限？
        // 数组的长度，应该不会是10w。 现在插入10w个数据，又不报错。
        // 为什么。谁帮我们做了什么事情。
        // JDK底层，帮助我们屏蔽了这些细节。
        Collection<Student> collection = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            collection.add(new Student());
        }

        System.out.println(collection.size());

    }
}

class Student {
    String name;
    int age;
    String address;


    public Student() {
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + ", address='" + address + '\'' + '}';
    }
}
