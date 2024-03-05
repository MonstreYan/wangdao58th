package com.cskaoyan._04oop1._07debug;

/**
 * 什么叫做debug。 调试。 一步一步的执行代码。
 * debug，就是让代码一行一行的执行。
 *
 * debug的目的是什么： 找bug。
 * 观察心理预期。  观察你的预期和代码的执行是否一致。
 * 观察了之后，调整代码。 调整到你的预期和代码实际运行是一致的。
 *
 * 打印。 也可以找bug。
 *
 * @author Common-zhou
 * @since 2024-03-05 16:41
 */
public class Demo1 {
    public static void main(String[] args) {
        int i = 10;
        i++;
        System.out.println(i);

        System.out.println(i + 10);
    }
}
