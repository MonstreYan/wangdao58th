package com.cskaoyan._01basic._03variable;

/**
 * @author Common-zhou
 * @since 2024-02-29 15:58
 */
public class Demo5 {
    public static void main(String[] args) {
        // Java中的浮点数。是怎么存的。

        // 10.56
        // 10005000000000  ==> 1.00005 * 10 ^

        // 科学计数法：

        // Java中的浮点数，两类。 float  double
        // float是4字节来存储数； double是8字节存储数

        // 所以double存储的数，范围更大，更精确。
        // 它俩都不精确.
        float f1 = 0.10000000001f;
        System.out.println(f1);

        double d1 = 0.1000000010000000000001;
        System.out.println(d1);

    }
}
