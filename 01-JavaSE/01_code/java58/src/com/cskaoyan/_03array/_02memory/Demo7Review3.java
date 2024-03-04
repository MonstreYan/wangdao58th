package com.cskaoyan._03array._02memory;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-04 10:16
 */
public class Demo7Review3 {
    public static void main(String[] args) {
        // 什么是引用数据类型。
        // 基本数据类型： 4类8种。
        // 在Java里面，除了基本数据类型， 都是引用数据类型。

        // 引用数据类型
        int[] arr = new int[5];

        // 基本数据类型。
        int a = 10;

    }


    @Test
    public void test1() {
        // 基本数据类型和引用数据类型。 打印变量名有所区别。
        // 基本数据类型，直接打印变量名，打印的就是该变量具体的值
        int a = 10;
        System.out.println(a);

        // 引用数据类型。 打印变量名，打印出来的是地址。
        int[] nums = {1, 2, 3};
        System.out.println(nums);

        // 那为什么String，没有打印地址。  ==》  toString()
        String s = "hello";
        System.out.println(s);


    }
}
