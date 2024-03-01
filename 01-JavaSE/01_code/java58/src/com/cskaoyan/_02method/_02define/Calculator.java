package com.cskaoyan._02method._02define;

/**
 * 定义一个计算器（Calculator）它的功能有：
 * <p>
 * 1. 加，减，乘，除
 * 2. 求平方
 * 3. 求a的n次方  Math.pow()
 * 4. ...
 *
 * @author Common-zhou
 * @since 2024-03-01 16:04
 */
public class Calculator {

    public static int add(int num1, int num2) {
        return num1 + num2;
    }

    public static int sub(int num1, int num2) {
        return num1 - num2;
    }

    public static int multy(int num1, int num2) {
        return num1 * num2;
    }


    public static double divide(int num1, int num2) {
        // 在Java中，一个int / 另一个int。结果是一个int。
        return 1.0 * num1 / num2;
        // return num1 / num2;

        // 后续，注意一下idea中特殊的颜色标识。

        // 'num1 / num2': integer division in floating-point context
    }


}
