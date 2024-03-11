package com.cskaoyan._05oop2._02extends._12final;

import java.util.ArrayList;

/**
 * @author Common-zhou
 * @since 2024-03-11 14:42
 */
public class Demo4 {
    public static void main(String[] args) {
        // 常量分两类。
        // 1.字面值常量

        // 1 = 2;
        // 2.自定义常量。被final修饰的变量，无法更改，这时候就是常量

        // 自定义常量的命名：
        // 类、接口命名： 大驼峰
        // 方法，变量命名： 小驼峰
        // 自定义常量命名：   全大写（用来代表它是一个常量。） 单词和单词要进行分割。 _ 分割。

        // 一定要遵循这个习惯。   遵循习惯，有什么好处？ 方便今后看别人的代码，自己写得代码，别人也能比较轻松的上手。
        new ArrayList<>();

        // MAXSTUDENTAGE
        // MAX_STUDENT_AGE

        // 为啥构造方法，是大驼峰。
    }
}
