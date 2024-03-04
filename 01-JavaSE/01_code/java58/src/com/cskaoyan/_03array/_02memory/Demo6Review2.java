package com.cskaoyan._03array._02memory;

/**
 * @author Common-zhou
 * @since 2024-03-04 10:00
 */
public class Demo6Review2 {

    public static void main(String[] args) {
        // 1.JVM的运行时数据区。
        // Java是一门语言， 需要存储各种各样的数据。 各种数据的生命周期不同，存在形式不同，需要存储这些数据
        // 因为各种数据有不同的特点，JVM需要分门别类的存储。 这样方便自己管理这些数据。
        // 很多东西，需要自己思考一下。 在面对面试官的时候。 如何去答这个问题。


        // JVM的运行时数据区， 主要划分五大部分。
        // 1）栈。  主要用来描述方法的执行过程。
        // 2）堆：  用来存储new出来的数据。
        // 3）本地方法栈
        // 4）方法区
        // 5）程序计数器。

        test1();
    }

    public static void test1() {
        int a = 1;
        System.out.println(a);

        test2();
    }

    public static void test2() {
        int a = 2;
        System.out.println(a);
    }


}
