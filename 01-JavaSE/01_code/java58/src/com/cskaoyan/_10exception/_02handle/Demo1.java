package com.cskaoyan._10exception._02handle;

/**
 * JVM的默认处理机制
 * 1. 当我们代码在执行到，发生错误的地方。
 * 2. 一旦发生错误，JVM就会终止我们自己程序的运行，转而执行JVM自己的错误处理流程
 * 3. 在发生错误地方，收集错误信息，产生一个描述错误的对象
 * 4. 返回收集到的错误信息，将错误信息，输出到控制台窗口中(哪个线程,异常类型名, 异常原因, 哪个类哪个方法哪一行报错了)
 *
 * @author Common-zhou
 * @since 2024-03-19 10:03
 */
public class Demo1 {
    public static void main(String[] args) {
        int i = 20;

        System.out.println("i = " + i);

        i += 10;
        System.out.println("i = " + i);

        // 引用数据类型。 默认值是10个null.
        Integer[] nums = new Integer[10];

        int i1 = nums[0].intValue();

        System.out.println(i1);
        // JVM代码是一行一行执行的，在产生错误的代码行数之前，代码可以正常运行。
        // 到了产生错误的这一行。 出现了异常。 JVM会终止你的代码的运行，转向它自己的错误处理流程。
        // （收集错误信息： 错误原因，异常类型，异常位置）   ====》 塞到一个错误对象里面。然后把这个错误对象返回。
        // 最终，错误对象，到达main方法，main方法终止运行。  之后会在控制台打印出错误的详细信息。

    }
}
