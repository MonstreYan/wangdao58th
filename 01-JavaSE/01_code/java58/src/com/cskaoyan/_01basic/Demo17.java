package com.cskaoyan._01basic;

/**
 * @author Common-zhou
 * @since 2024-02-29 17:53
 */
public class Demo17 {
    public static void main(String[] args) {
        // 三目运算符.三元运算符

        // (条件表达式) ? 表达式1 : 表达式2;
        // 如果条件表达式为真, 执行表达式1； 否则，执行表达式2
        // 求两者的较大值

        int num1 = 10;
        int num2 = 20;

        int maxValue2 = (num1 > num2) ? num1 : num2;

        System.out.println("maxValue2 = " + maxValue2);

        int maxValue;
        if (num1 >= num2) {
            //较大值 num1
            maxValue = num1;
        } else {
            // 较大值是num2
            maxValue = num2;
        }

        System.out.println("maxValue = " + maxValue);


        System.out.println("================================================");

        int a = 2;
        int b = 4;
        int c = 8;

        // 求三个数的最大值
        // 三目运算符不要随意用，因为代码的可读性有时候有问题。
        int max = (a > b) ? (a > c) ? a : c : (b > c) ? b : c;
        boolean flag = true ? false : true == true ? false : true;

    }
}
