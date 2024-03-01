package com.cskaoyan._01basic._05scanner;

import java.util.Scanner;

/**
 * @author Common-zhou
 * @since 2024-03-01 09:42
 */
public class Demo3 {
    public static void main(String[] args) {
        // 1. 键盘录入String字符串，可以选择使用nextLine方法。
        // 2. 键盘录入int数值，可以选择使用nextInt方法。
        // 3. 键盘录入double数值，可以选择使用nextDouble方法。

        // 使用Scanner在需要录入多种数据类型时，建议不要混用以上方法。比如：
        // 使用Scanner不同方法录入多种数据

        // 先录入一个int， 再录入一个String.   打印int，打印String

        Scanner sc = new Scanner(System.in);

        // 3\n
        int num = sc.nextInt();
        String s = sc.nextLine();

        System.out.println(num);
        System.out.println("===" + s + "===");
        // nextInt碰到空格、制表符、回车就会结束
        // nextLine 碰到回车会结束。




    }
}
