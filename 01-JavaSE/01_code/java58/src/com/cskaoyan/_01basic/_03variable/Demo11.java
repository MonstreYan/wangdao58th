package com.cskaoyan._01basic._03variable;

/**
 * 注意事项
 *
 * @author Common-zhou
 * @since 2024-02-29 16:35
 */
public class Demo11 {
    public static void main(String[] args) {
        // 1.Java当中的整数字面值常量，默认当作int处理。
        // 21000_000_000   ====  21000000000
        // long l1 = 21000_000_000;
        // 认为这个数。 是一个int 21000_000_000
        // 想声明long。 可以加L。 加大写的L   不要加小写的l
        // long l2 = 21000_000_000l;
        long l3 = 21000_000_000L;
        System.out.println(l3);


        // 2.在Java中，小数的字面值，默认会当做double。 如果说想声明，float的变量， 可以在常量的后面，加 f或者 F

        // float f1 = 0.1F;
        float f1 = 0.1f;


    }
}
