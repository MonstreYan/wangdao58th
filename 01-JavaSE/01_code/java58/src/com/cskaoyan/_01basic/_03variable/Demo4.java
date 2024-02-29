package com.cskaoyan._01basic._03variable;

/**
 * 基本数据类型：Java中定义了四类八种基本数据类型。
 * 整形：
 *
 * @author Common-zhou
 * @since 2024-02-29 15:50
 */
public class Demo4 {
    public static void main(String[] args) {
        // - byte
        //   - byte类型也叫字节型，仅占1个字节内存空间，即8位。
        // 表示范围： 0

        byte b1 = 127;
        // byte b2 = 128;
        System.out.println(b1);


        // - short
        //   - short 也叫短整型，占用2个字节内存空间，16位。
        //   - 短整型只比字节型稍大，实际开发中short使用频率也不高。
        short s1 = 128;
        // short s2 = 65535;

        // int
        // - int 本身就是单词integer的缩写，占用4个字节内存空间, 即32位
        // - int 是最常用的整数数据类型，实际开发中整数往往都是int类型的。
        int i1 = 65535;
        // int的范围： -21亿 - +21亿


        // long l1 = ;


        // Java程序的数字进制:
        // - 0b 表示的是二级制
        // - 0 表示的是八级制
        // - 0x 表示的是十六级制
        // - 默认的是十进制

        // 在Java中，如果写了一个数字，这个数字是十进制的
        // 默认就是10进制的
        int j = 25;

        // 16 + 4 + 1 = 21
        int j1 = 0b010101;
        System.out.println(j1);

        int j2 = 0x1a1b;
        System.out.println(j2);

    }

}
