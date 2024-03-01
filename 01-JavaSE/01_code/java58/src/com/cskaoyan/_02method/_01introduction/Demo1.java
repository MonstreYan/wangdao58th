package com.cskaoyan._02method._01introduction;

import org.junit.Test;

/**
 * // root  123456
 * // sadjkhsaKJDHASJKDHSAKJDKJSA:3306
 * // hfjdshjkdfs
 * // dsajjdhasjk
 * <p>
 * idea里面的一些使用。 快捷键。
 *
 * @author Common-zhou
 * @since 2024-03-01 14:48
 */
public class Demo1 {
    @Test
    public void test1() {
        // 1. 编写程序，计算10+20，并输出结果
        // 2. 编写程序，计算111+222，并输出结果
        // 3. 编写程序，计算333+444，并输出结果

        int num1 = 10;
        int num2 = 20;
        int sum = num1 + num2;
        System.out.println(sum);

        // Variable 'num1' is already defined in the scope
        // 要学会看各种报错。  红色波浪线。
        // int num1 = 111;

        int num3 = 111;
        int num4 = 222;
        // ctrl + alt +v 快速帮我们生成左边的变量。
        int sum2 = num3 + num4;
        System.out.println(sum2);


    }
}
