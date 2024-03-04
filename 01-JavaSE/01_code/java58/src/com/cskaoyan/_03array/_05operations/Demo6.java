package com.cskaoyan._03array._05operations;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Common-zhou
 * @since 2024-03-04 15:18
 */
public class Demo6 {
    @Test
    public void test1() {
        // 很多时候，我们都是在对数据进行增删改查。
        // crud
        // crud boy工程师。
        // 所以，对一个数据进行增删改查。 非常重要。

        // 比如，你现在，在为你们学校开发一个学生管理系统。
        // 学生管理系统里面，大致会有哪些功能。
        // 增加学生。
        // 删除学生
        // 修改学生信息
        // 查找学生

        // 现阶段，对数据的增删改查。 非常重要。
    }

    @Test
    public void test2() {
        // 需求1： 现在，我们想存储一个班级的所有学生名字。

        // 第一行输入，输入的同学的数目
        // 后面的每一行， 都输入的同学的名字。

        // input1:
        // 2
        // zhangsan
        // lisi

        // input2:
        // 3
        // zhangsan
        // lisi
        // wangwu


        System.out.println("请输入学生的个数：");
        Scanner scanner = new Scanner(System.in);

        int studentNumber = Integer.parseInt(scanner.nextLine());
        String[] studentNames = new String[studentNumber];

        for (int i = 0; i < studentNumber; i++) {
            String studentName = scanner.nextLine();
            studentNames[i] = studentName;
        }

        System.out.println(Arrays.toString(studentNames));

    }

    @Test
    public void test3() {

        // 假设，给你了数组。是学生的姓名。

        // 删除一个叫做zhangsan 的同学。

        String[] studentNames = {"zhangsan", "lisi", "wangwu", "zhaoliu"};

        // 可以将 找到zhangsan这个数据。然后将zhangsan后面的数据往前挪动。最终把数组最后一个数据，置为null

        // ArrayList  LinkedList
        // 数组。  链表。
        // 它会想问你。 数组和链表有什么区别。
        // 晚上，要自己先练习一下。 怎么进行增删改查 数组。


    }
}
