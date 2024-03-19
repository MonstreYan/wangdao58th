package com.cskaoyan._10exception._02handle;

/**
 * JVM的异常默认处理机制。  方法调用层数多
 * <p>
 * 异常的输出， 可能和大家所理解的不一样。 顺序可能有所偏差。
 *
 *
 * JVM的默认处理机制：
 * 1.代码在产生异常之前，会一行一行运行。
 * 2.到达产生错误的这行后。 JVM会中止你的代码的运行，转而开始执行自己的错误处理流程
 * 3.收集错误信息：错误的类型、错误的原因、方法的调用栈（异常在哪一行产生的，从哪个方法调进去）。产生一个错误对象，塞到错误对象里面
 * 4.将这个错误对象往上抛。一直抛，抛到JVM挂掉（抛到主方法之外。）
 *
 * JVM的默认处理机制。 是不是程序员想要的？不是。
 * 所以程序员有另外一个方式。===》 自己来处理错误。
 *
 * @author Common-zhou
 * @since 2024-03-19 10:12
 */
public class Demo2 {

    public static void main(String[] args) {

        System.out.println("main start");
        test1();
        System.out.println("main end");
    }

    private static void test1() {
        System.out.println("test1 start");
        test2();
        System.out.println("test1 end");
    }

    private static void test2() {
        System.out.println("test2 start");
        test3();
        System.out.println("test2 end");
    }

    private static void test3() {
        System.out.println("test3 start");
        int i = 1 / 0; // 一旦运行到错误代码，JVM会收集错误信息，产生一个错误对象。 往上返回，直到返回到main方法，
        System.out.println("test3 end");
    }
}
