package com.cskaoyan._12io._02charstream;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author Common-zhou
 * @since 2024-03-21 10:58
 */
public class Demo1 {
    @Test
    public void test1() {
        // 字符在计算机中，是如何存储的。
        // 是依赖于编码表。

        // 编码表，就是运用科学的手段，将所有需要表示的东西，用数字与之对应。
        // a  ----->  97
        // 你  ---->   20320
        char c = '你';
        System.out.println(c + 0);

        // 科学: 什么叫做科学的手段。 用的多的用少一些的存储空间。
        // abc
        // 龘

        // 这个就是各国（各个机构，用来编码的主要依据）

        // 对于中国人来说，
        // 日本
    }

    @Test
    public void test2() throws UnsupportedEncodingException {
        // UTF-8：可变长度来表示一个字符。
        // UTF-8不同，它定义了一种“区间规则”，这种规则可以和ASCII编码保持最大程度的兼容：
        // 可变长的字符集。  使用1-4个字节来表示一个字符。
        //
        // 中文一般是使用三个字节来表示一个字符。 4个字节来存这个表情符号。

        // a  b  c
        // 一般的英文符号，是使用一个字节来存的。

        String s = "a";
        byte[] bytes = s.getBytes("UTF-8");
        System.out.println(Arrays.toString(bytes));

        String s1 = "你";
        byte[] bytes1 = s1.getBytes("GBK");
        System.out.println(Arrays.toString(bytes1));

        // GBK 兼容 ASCII。

    }


    @Test
    public void test3(){
        // UTF-8    3个字节表示一个中文字符
        // 里面有一些自己的策略。 用一些前置位来不存储数。光存标识。

        // 97  98 99

        // 111  01

        // 110  01010


        // 后期可以自己去看看UTF-8. 现在，先知道这是个编码表。 用3字节来存储中文。
    }
}
