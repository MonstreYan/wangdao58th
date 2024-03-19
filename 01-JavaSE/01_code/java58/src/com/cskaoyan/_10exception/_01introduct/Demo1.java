package com.cskaoyan._10exception._01introduct;

/**
 * Java里面的异常。 Throwable是一个顶层父类，它是所有错误和异常的顶层父类。
 * <p>
 * <p>
 * 按照严重程度来分：
 * Error: 错误。程序员没有办法手动出来（在代码里面处理）
 * java.lang.StackOverflowError 栈溢出
 * java.lang.OutOfMemoryError 堆溢出: 对象创建太多了。  ==》 后面再演示。
 * Exception: 异常，错误程度比较小，在代码里面能处理。
 * @author Common-zhou
 * @since 2024-03-19 09:42
 */
public class Demo1 {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        test1();
    }

}
