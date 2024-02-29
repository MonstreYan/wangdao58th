package com.cskaoyan._01basic;

/**
 * 字符型
 *
 * @author Common-zhou
 * @since 2024-02-29 16:04
 */
public class Demo6 {
    public static void main(String[] args) {
        // 在Java中，字符型就是专门用来存储字符的
        // 在计算机中，只能存储  0 1 。最终a，也要存起来，怎么存的？

        // 编码的东西。
        // a  ===》 转换为数。   97   ===>    存入磁盘
        // 读出来是97.直接把97转换为a
        char c1 = 'a';
        System.out.println(c1);


        // 如果我们直接打印  'a'
        // 直接出来就是 a

        // 如果我们让它参与了计算，这时候就会变成编码值
        System.out.println(c1 + 1 - 1); // 97
        // 在Java中，使用97这个数， 来代表a
        char c2 = 97;
        System.out.println(c2);


        // 布尔类型： boolean，在Java中，布尔类型只有一个。  boolean
        // boolean类型的值，只有真和假
        boolean flag = true;

        boolean flag1 = false;


    }
}
