package com.cskaoyan._10exception._02handle;

/**
 * @author Common-zhou
 * @since 2024-03-19 10:32
 */
public class Demo3 {
    public static void main(String[] args) {
        // int i = 1 / 0;
        double v = 1.0 / 0; // 在Java里面1.0 /0 没问题

        // Infinity: 无穷大
        // Java里面的double。有一个叫做无穷大、 无穷小。
        System.out.println(v);
    }
}
