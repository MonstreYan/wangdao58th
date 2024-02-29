package com.cskaoyan._01basic._03variable;

/**
 * 浮点数，精度有问题。
 *
 * @author Common-zhou
 * @since 2024-02-29 16:42
 */
public class Demo12 {
    public static void main(String[] args) {

        // 1. 使用Java代码计算 10 / 3.0
        // 2. 使用Java代码计算 1 - 0.9

        // Java中 float和double进度有问题。
        double v = 10 / 3.0;
        System.out.println(v);

        System.out.println(1 - 0.9);

        // float和double都不适合用于精确计算的场合，尤其不适合用于货币运算。
        // 在代码里面，需要计算钱这个东西的时候，一定不要使用 float和double
        // BigDecimal

    }

}
