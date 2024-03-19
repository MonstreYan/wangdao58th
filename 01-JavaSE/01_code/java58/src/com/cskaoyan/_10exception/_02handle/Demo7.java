package com.cskaoyan._10exception._02handle;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-19 11:20
 */
public class Demo7 {
    public static void main(String[] args) {

        try {
            int i = 1 / 0;
        } catch (ArithmeticException e) {
            // 这个e就是。JVM帮我们封装的错误信息。 包括 线程、错误的行数、错误的类型、错误的原因
            // getMessage() 就是拿到错误的信息。  其实就是冒号后面的东西
            System.out.println("e.getMessage() = " + e.getMessage());
            // 会打印异常类型 + 错误信息。
            System.out.println(e);

            // printStackTrace： 打印所有的信息。
            e.printStackTrace();
        }

        // 后期大家在抓到异常之后。一定一定要注意； 一定要打印出来，或者抛上去。 不要私吞了
    }


    @Test
    public void test2() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            // e.printStackTrace();
            // 一定要把e打印出来。否则后期查bug。 无头苍蝇
        }

        System.out.println("test2");

        // 平均值。
        // 比最大值都大
        // 3000家。    15个。
        // 运维： Linux. 日志。 把控制台的所有信息，全存储到文件上。
        // 日志里面啥也没有。
        //

    }
}
