package com.cskaoyan._02method._02define;

/**
 * 定义一个方法，求圆的面积：
 * <p>
 * 1. 方法参数:半径 (radius)
 * 2. 圆周率:3.14（获取用Math.PI获取）
 *
 * @author Common-zhou
 * @since 2024-03-01 16:11
 */
public class Demo5 {

    public static double calculateCircleArea(int radius) {
        return 3.14 * radius * radius;
    }

    public static void main(String[] args) {
        System.out.println("calculateCircleArea(10) = " + calculateCircleArea(10));
        System.out.println("calculateCircleArea(20) = " + calculateCircleArea(20));
    }
}
