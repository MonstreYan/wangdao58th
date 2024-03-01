package com.cskaoyan._02method._02define;

/**
 * 关于主方法的说明。
 *
 * @author Common-zhou
 * @since 2024-03-01 16:26
 */
public class Demo8MainMethod {

    // 方法的修饰符   public static
    // 方法的返回值  void  . 代表该方法不需要返回值
    // 方法名  main   main不是一个关键词。但是main现在已经被作为一个约定俗称的JVM的入口。
    // 只要开始运行代码，JVM就开始找main方法，然后执行main方法。
    // 形参列表： String[] args   数组。 这个就是JVM里面传过来的各种参数。


    public static void main(String[] args) {
        int main = 1;
        System.out.println(main);

    }
}
