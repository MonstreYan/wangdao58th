package com.cskaoyan._01basic._07select;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author Common-zhou
 * @since 2024-03-01 10:31
 */
public class Demo3 {
    @Test
    public void test1() {
        // 1. 键盘录入x的值，计算出y的并输出。
        // 其中x和y的关系满足如下：
        // 1. x>=3时，y = 2x + 1;
        // 2. -1<=x<3时， y = 2x;
        // 3. x<-1时， y = 2x – 1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个x：");
        int x = scanner.nextInt();

        int y = 0;

        if (x >= 3) {
            y = 2 * x + 1;
        } else if (x >= -1) {
            y = 2 * x;
        } else if (x < -1) {
            y = 2 * x - 1;
        }

        // 一旦遇到红色的波浪线： 把鼠标浮动上去看一下。
        // Variable 'y' might not have been initialized
        System.out.println(y);
    }

    @Test
    public void test2() {
        // 2. 键盘录入月份的值，输出对应的季节。

        // 冬季： 12 1 2
        // 春： 3 4 5
        // 夏： 6 7 8
        // 秋： 9 10 11

        Scanner scanner = new Scanner(System.in);

        int inputMonth = scanner.nextInt();

        String inputSeason = "";

        if (inputMonth == 12 || inputMonth == 1 || inputMonth == 2) {
            // 代表是冬季
            inputSeason = "冬季";
        } else if (inputMonth == 3 || inputMonth == 4 || inputMonth == 5) {
            // 代表是春
            inputSeason = "春季";
        } else if (inputMonth == 6 || inputMonth == 7 || inputMonth == 8) {
            // 代表是夏季
            inputSeason = "夏季";
        } else if (inputMonth == 9 || inputMonth == 10 || inputMonth == 11) {
            // 代表是秋季
            inputSeason = "秋季";
        }


        System.out.println(inputSeason);


    }

}
