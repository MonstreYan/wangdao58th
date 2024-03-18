package com.cskaoyan._09string._01introduct;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-18 09:41
 */
public class Demo1 {

    @Test
    public void test1(){
        // - 一个字符串是由多个字符组成的一串数据(字符序列,字符数组)
        // - String类代表字符串,Java 程序中的所有字符串字面值（如 "abc" ,"你好","の"）都作为此类的实例实现
        // - 在java.lang包下,是java核心类,最常用类,但是不属于基本数据类型,引用类型
        // - String类提供了字符串表示、比较、查找、截取、大小写转换等各种针对字符串的操作


        String abc = "abc";
        String de = "の";

        // String类，比较常用。它是不是基本数据类型？  ===》 基本数据类型， 4类8种。

        String s1 = "hello world";

        String lowerCase = s1.toLowerCase();
        String upperCase = s1.toUpperCase();

    }

}
