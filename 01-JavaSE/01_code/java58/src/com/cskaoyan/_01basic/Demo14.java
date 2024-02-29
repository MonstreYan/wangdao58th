package com.cskaoyan._01basic;

/**
 * @author Common-zhou
 * @since 2024-02-29 17:19
 */
public class Demo14 {
    public static void main(String[] args) {
        // String作为字符串类型，也可以使用" + "在表达式中参与运算，
        // 称之为"字符串的拼接"。 任何表达式一旦有字符串拼接运算，那么结果必然是String类型。

        String s1 = "hello";
        String s2 = "world";

        // 在字符串相加的时候。表现为字符串的拼接
        String s = s1 + s2;

        System.out.println(s);

        System.out.println('a'); // a
        System.out.println('a' + 1); // 98
        System.out.println("hello" + 'a' + 1); // helloa1
        System.out.println('a' + 1 + "hello"); //  98hello
        System.out.println("5 + 5 = " + 5 + 5); // 5 + 5 = 55
        System.out.println(5 + 5 + " = 5 + 5"); // 10 = 5 + 5
        System.out.println(5 + 5.0); // 10.0
        System.out.println(5 + "5" + 5.0); // 555.0

    }
}
