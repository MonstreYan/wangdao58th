package com.cskaoyan._03array._05operations;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Common-zhou
 * @since 2024-03-04 15:48
 */
public class Demo7 {
    @Test
    public void test1Copy() {
        // 数组的拷贝
        // 数组的长度是不可以改变的，所以如果想要实现数组元素"真正意义上的"删除和新增，一般需要使用数组的拷贝。
        // 大致思路是，创建一个新数组,然后拷贝赋值：
        // 1. 首先需要明确新数组的长度，初始化这个新数组。
        // 2. 然后遍历原先的数组，过滤掉（或者新增）一些元素，给新数组赋值。

        String[] studentNames = {"zs", "ls", "wu", "zl"};

        // 现在，想拷贝一份数据。 拿到学生名字的副本
        // 这个不叫拷贝。
        // String[] studentNamesCopy = studentNames;

        String[] studentNamesCopy = new String[studentNames.length];

        for (int i = 0; i < studentNames.length; i++) {
            studentNamesCopy[i] = studentNames[i];
        }

        System.out.println(Arrays.toString(studentNames));
        System.out.println(Arrays.toString(studentNamesCopy));

        studentNamesCopy[0] = "zhangsan";

        System.out.println(Arrays.toString(studentNames));
        System.out.println(Arrays.toString(studentNamesCopy));

    }
}
