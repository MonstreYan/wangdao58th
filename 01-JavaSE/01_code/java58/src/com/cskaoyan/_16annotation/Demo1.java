package com.cskaoyan._16annotation;

import org.junit.Test;

/**
 * 注解和注释
 * <p>
 * 注释： 就是描述性的文字。 给程序员自己用。
 *
 * @author Common-zhou
 * @since 2024-03-26 11:48
 */
public class Demo1 {
    public static void main(String[] args) {
        System.out.println("hello world");
    }

    // 注解其实就是额外传递信息的。 但是这个信息，可以参与编译，甚至在运行的时候都能起作用。，
    @Test
    public void test1() {
        System.out.println("hello ");
    }
}
