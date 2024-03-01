package com.cskaoyan._02method._03overload;

/**
 * 使用方法重载，控制台输出各种数据类型。
 *
 * @author Common-zhou
 * @since 2024-03-01 17:11
 */
public class Demo6 {
    public static void main(String[] args) {
        // 只要一个方法， 是 public static 的。 我们再另一个类中，可以调用。
        // 通过类名 + 方法名 来调用
        Print1.print(10);
        Print1.print(1.0);

        // System.out.println();
    }
}
