package com.cskaoyan._09string._04api;

import org.junit.Test;

/**
 * String是字符串类。 Java提供了很多API给我们使用。
 *
 * @author Common-zhou
 * @since 2024-03-18 11:44
 */
public class Demo1 {

    @Test
    public void test1() {
        // 用来比较字符串的内容，注意区分大小写
        // boolean equals(Object obj)

        String s1 = "heLlo";
        String s2 = "Hello";

        System.out.println("s1.equals(s2) = " + s1.equals(s2));

        // 先理解API。然后后续使用的时候看名字使用。
        // 下一次，如果JDK里面，名字是这个，但是实现的时候不是这样实现。  ===》 JDK的bug。
        // 规范。

        // 忽略字符串大小写比较字符串内容，常见用于比较网址URL
        // boolean equalsIgnoreCase(String str)


        System.out.println("s1.equalsIgnoreCase(s2) = " + s1.equalsIgnoreCase(s2));

    }

    @Test
    public void test2() {
        // 判断一个字符串，是不是空字符串
        // boolean isEmpty()

        String s1 = "hello";
        String s2 = "";
        String s3 = "    ";
        System.out.println("s1.isEmpty() = " + s1.isEmpty());
        System.out.println("s2.isEmpty() = " + s2.isEmpty());
        System.out.println("s3.isEmpty() = " + s3.isEmpty());

        // 比如，遇到一些API，你也不认识。 你看名字觉得好像可以用。但是又不知道特征
        // 点进去。 在方法上有详细的描述
        System.out.println("s2.isBlank() = " + s2.isBlank());
        System.out.println("s3.isBlank() = " + s3.isBlank());

    }

    @Test
    public void test3() {
        // 一定要注意空指针。
        // 一定不能用null。 去点任何方法，任何属性
        String s = "";
        System.out.println("s.isEmpty() = " + s.isEmpty());

        String s1 = null;
        System.out.println("s1.isEmpty() = " + s1.isEmpty());
    }

    @Test
    public void test5(){
        // 判断当前字符串对象是否包含，目标字符串的字符序列
        // boolean contains(String str)
        //
        // 判断当前字符串对象，是否已目标字符串的字符序列开头
        // boolean startsWith(String str)
        //
        // 判断当前字符串，是否以目标字符串对象的字符序列结尾，常用于确定文件后缀名格式
        // boolean endsWith(String str)
    }

}
