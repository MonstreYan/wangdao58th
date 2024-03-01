package com.cskaoyan._02method._03overload;

/**
 * 引例，现在有三个需求，需要写三个方法完成：
 * 1. 编写程序，计算两个int类型数据之和，并输出结果
 * 2. 编写程序，计算两个double类型数据之和，并输出结果
 * 3. 编写程序，计算两个long类型数据之和，并输出结果
 * <p>
 * 写完方法后，请问这个程序有哪些缺点呢？
 *
 * @author Common-zhou
 * @since 2024-03-01 16:30
 */
public class Demo1 {
    public static int sumInt(int num1, int num2) {
        return num1 + num2;
    }

    public static double sumDouble(double d1, double d2) {
        return d1 + d2;
    }

    public static long sumLong(long l1, long l2) {
        return l1 + l2;
    }


    public static void main(String[] args) {
        System.out.println("sumInt(10, 20) = " + sumInt(10, 20));
        System.out.println("sumLong(10L, 30L) = " + sumLong(10L, 30L));
    }
}
