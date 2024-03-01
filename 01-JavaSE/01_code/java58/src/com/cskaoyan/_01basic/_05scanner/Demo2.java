package com.cskaoyan._01basic._05scanner;

import java.util.Scanner;


/**
 * Scanner使用完。 再来说@Test
 *
 * @author Common-zhou
 * @since 2024-03-01 09:37
 */
public class Demo2 {
    public static void main(String[] args) {
        // 2.创建Scanner
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个数字：");
        // 3.读取数据
        int num = sc.nextInt();

        System.out.println("输入进来的数字：" + num);
    }
}
