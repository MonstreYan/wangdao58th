package com.cskaoyan._01basic._06escape;

/**
 * @author Common-zhou
 * @since 2024-03-01 10:18
 */
public class Demo1 {
    public static void main(String[] args) {
        // 转义字符： 就是有一些字符，无法直接表示。 需要通过 另外一些特殊的符号来表示
        // 换行。
        // 这些符号，一般都是用反斜杠开头。

        System.out.println("11\n22");

        System.out.println("12\'34");
        // 想输出一个 双引号
        System.out.println("12\"34");
    }
}
