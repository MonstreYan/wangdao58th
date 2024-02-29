package com.cskaoyan._01basic._04operator;

/**
 * @author Common-zhou
 * @since 2024-02-29 17:32
 */
public class Demo16 {
    public static void main(String[] args) {
        // 表达式和语句

        // 表达式一般有结果

        // 1+2;// 表达式。

        // 语句是可以单独执行的代码，以分号进行结尾
        // 但是是没有结果的
        int i = 1 + 2;

        System.out.println("11111");


        int x = 4;
        int y = (x++) + (++x) + (x * 10);

        System.out.println("x = " + x);
        System.out.println("y = " + y);


    }
}
