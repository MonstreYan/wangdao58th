package com.cskaoyan._01basic._03variable;

/**
 * @author Common-zhou
 * @since 2024-02-29 16:15
 */
public class Demo7 {
    public static void main(String[] args) {
        // 引用数据类型： 在Java中，除了基本数据类型之外，其他的都是引用数据类型。
        // 除了这些，都是引用数据类型。
        // 四类八种基本数据类型。
        // byte short int long
        // float double
        // char
        // boolean

        // String类。就是Java提供给我们，用来标识字符串的。
        // 只用是用 "" 引起来的，就是String类。
        String s1 = "hello world";
        System.out.println(s1);

        // 关于，如何比较两个字符串，是否相等。
        String s2 = "hello world";

        // 对于引用数据类型的比较，都使用equals方法进行比较。 不要使用 == 来进行比较。
        // s1 == s2
        // s1.equals(s2)

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));


    }

}
