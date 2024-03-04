package com.cskaoyan._03array._03example;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Common-zhou
 * @since 2024-03-04 11:13
 */
public class Demo1 {
    @Test
    public void test1() {
        // 静态初始化一个数组，输出数组名及元素。然后给数组中的元素赋值，再次输出数组名及元素。

        // 创建一个数组，存储班级中的学生。  陈健、常旭、冯娅骊、景天

        String[] students = new String[]{"陈健", "常旭", "冯娅骊", "景天"};

        // 打印出来的是地址. 直接打印数组名
        System.out.println(students);
        // 下标的取值， 只能是：[0, length-1]
        System.out.println(students[0]);
        System.out.println(students[1]);
        System.out.println(students[2]);
        System.out.println(students[3]);

        // 景天   奶茶叔叔
        students[3] = "奶茶叔叔";

        // System.out.println(students[0]);
        // System.out.println(students[1]);
        // System.out.println(students[2]);
        // System.out.println(students[3]);

        // Arrays.toString(students)  就是将数组里面的数据，转换为字符串。
        System.out.println("Arrays.toString(students) = " + Arrays.toString(students));
    }

    @Test
    public void test2() {
        // 分别静态、动态初始化两个数组，分别输出数组名及元素。然后分别给数组中的元素赋值，再次分别输出数组名及元素。
    }

    @Test
    public void test3() {
        // 定义两个数组：
        // - 静态初始化一个数组，输出数组名，元素取值，长度
        // - 然后声明第二个数组，把第一个数组的地址赋值给第二个数组。
        // - 输出第二个数组的数组名，元素取值，长度
        // - 然后给第二个数组赋值，再次输出两个数组的名及元素

        String[] students = new String[]{"陈健", "常旭", "冯娅骊", "景天"};
        // 数组的名
        System.out.println("students = " + students);
        System.out.println(students.length);

        String[] students2 = students;

        System.out.println("===================chang students2 before===================");
        System.out.println("students2 = " + students2);

        System.out.println(students2.length);
        System.out.println("students2[0] = " + students2[0]);
        System.out.println("students2[1] = " + students2[1]);
        System.out.println("students2[2] = " + students2[2]);
        System.out.println("students2[3] = " + students2[3]);

        students2[3] = "奶茶叔叔";

        System.out.println("===================chang students2 after===================");
        System.out.println("students2 = " + students2);
        System.out.println(students2.length);
        System.out.println("students2[0] = " + students2[0]);
        System.out.println("students2[1] = " + students2[1]);
        System.out.println("students2[2] = " + students2[2]);
        System.out.println("students2[3] = " + students2[3]);
    }


    @Test
    public void test4() {
        // 简化一下代码，用来画图。

        String[] students = new String[]{"陈健", "常旭", "冯娅骊", "景天"};
        // 数组的名
        System.out.println("students = " + students);


        String[] students2 = students;

        System.out.println("students2 = " + students2);
        System.out.println("Arrays.toString(students) = " + Arrays.toString(students));
        System.out.println("Arrays.toString(students2) = " + Arrays.toString(students2));

        students2[3] = "奶茶叔叔";
        System.out.println("students2 = " + students2);
        System.out.println("Arrays.toString(students) = " + Arrays.toString(students));
        System.out.println("Arrays.toString(students2) = " + Arrays.toString(students2));


    }
}
