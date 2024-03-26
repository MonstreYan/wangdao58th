package com.cskaoyan._17gc;

/**
 * gc：   Garbage Collection
 * <p>
 * C/ C++  需要自己管理内存。
 * <p>
 * Java/C# : 系统帮你管理内存。释放内存。
 * <p>
 * C/C++ : 程序能不能帮我处理处理。
 * Java： JVM都帮我管理内存了，能不能让我自己管一管。 装b。
 * <p>
 * <p>
 * 对于JVM来说，很重要的一个工作。就是如何确定这是个垃圾。
 * 在Java中，如何确定是垃圾，肯定不是随机。
 *
 * @author Common-zhou
 * @since 2024-03-26 16:27
 */
public class Demo1 {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        User user = new User();

        // 到这，user用不用。 是不是垃圾？
        // JVM的核心问题： 什么对象是垃圾。
        System.out.println(user);

    }
}

class User {
}
