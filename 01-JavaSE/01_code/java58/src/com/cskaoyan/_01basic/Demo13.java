package com.cskaoyan._01basic;

/**
 * @author Common-zhou
 * @since 2024-02-29 17:04
 */
public class Demo13 {
    public static void main(String[] args) {
        // Java中，数据类型转换。
        // Java是一个强类型的语言，一旦声明变量的类型，变量类型就不能轻易转换。

        // Java中的类型转换分为两类：
        // 1.自动类型转换： 可以自动完成类型的转换。 发生在小转大
        // 2.强制类型转换


        byte b1 = 12;

        short s1 = b1;

        int i1 = b1;

        // char  是一个字符。使用两个字节来存储的数，用这个数来表示字符。
        char c1 = '你';
        // 20320
        int i2 = c1;

        System.out.println(i2);

        char c2 = 20320;
        System.out.println(c2);


        // 强制类型转换： 就是大取值范围，转换为小取值范围
        int i3 = 20;

        byte b3 = 20;
        // 因为，你要把一个int类型的值，转换为一个byte 类型。这时候就有问题。  需要强制类型转换
        // 目标类型  变量名 = (目标类型)原变量;
        byte b4 = (byte) i3;
        // 强制类型转换极易造成数据的丢失和失真。 除非特别有必要，不建议进行强制类型转换。

    }
}
