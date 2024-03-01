package com.cskaoyan._01basic._07select;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author Common-zhou
 * @since 2024-03-01 11:03
 */
public class Demo4Switch {
    public static void main(String[] args) {
        int month = 1;

        // switch这里，在每一个case里面，一定要加break。不然不会跳出去。
        switch (month) {
            case 1:
                System.out.println("这是1");
                break;
            case 2:
                System.out.println("这是2");
                break;
            case 3:
                System.out.println("这是3");
                break;
            default:
                System.out.println("这是default");
                break;
        }

    }

    @Test
    public void test2() {
        // 冬季： 12 1 2
        // 春： 3 4 5
        // 夏： 6 7 8
        // 秋： 9 10 11

        Scanner scanner = new Scanner(System.in);

        int inputMonth = scanner.nextInt();

        String inputSeason = "";


        switch (inputMonth) {
            case 12:
            case 1:
            case 2:
                inputSeason = "冬季";
                break;
            case 3:
            case 4:
            case 5:
                inputSeason = "春季";
                break;
            case 6:
            case 7:
            case 8:
                inputSeason = "夏季";
                break;
            case 9:
            case 10:
            case 11:
                inputSeason = "秋季";
                break;
            default:
                System.out.println("输入错误");
                break;
        }


        System.out.println(inputSeason);
    }
}
