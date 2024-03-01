package com.cskaoyan._02method._02define;

/**
 * 1. 求两个数的最大值。
 * <p>
 * 2. 键盘录入两个值，求最大值。
 * 3. 定义一个方法用于判断一个正整数的奇偶性，要求：
 * 1. 奇数方法返回false
 * 2. 偶数方法返回true
 *
 * @author Common-zhou
 * @since 2024-03-01 15:20
 */
public class Demo2 {

    //  [修饰符列表] 返回值类型 方法名(形参列表){
    //    // 方法体
    //  }
    //  1. 求两个数的最大值。
    public static int max(int num1, int num2) {
        // 这个方法的作用： 求两个数的最大值。
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }

        // Math.max(num1, num2);
    }


    public static void main(String[] args) {
        // 打印的直接就是返回结果。 我们可以直接操作一个方法的返回结果
        System.out.println(max(10, 20));


        int max = max(20, 60);
        System.out.println(max);
    }

}
