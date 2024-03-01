package com.cskaoyan._01basic._05scanner;

import org.junit.Test;

import java.util.Scanner;

/**
 * Scanner。
 * 如果大家晚上发现，在@Test的方法中，无法使用Scanner输入
 * -Deditable.java.test.console=true
 * 在 help-Edit Custom VM Options里面加。 之后重启idea。
 *
 * 如果在@Test的方法内部，使用Scanner的时候，无法输入。 （你按任何东西，都不显示）
 * 千万要注意： 不要改错了。  改错可能会导致idea无法启动。
 *
 * @author Common-zhou
 * @since 2024-03-01 10:10
 */
public class Demo6 {
    public static void main(String[] args) {
        // Scanner是用来干什么的？  从键盘录入数据的。
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        System.out.println(s);
    }

    @Test
    public void test1() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一个字符串：");
        String s = scanner.nextLine();
        System.out.println(s);
    }
}
