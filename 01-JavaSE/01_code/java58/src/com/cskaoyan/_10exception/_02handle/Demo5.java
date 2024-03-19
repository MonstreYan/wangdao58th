package com.cskaoyan._10exception._02handle;

/**
 * catch的时候，只针对性的抓异常。 不是所有异常都抓
 * <p>
 * <p>
 * 1.从上往下执行。
 * 2.try-catch里面，还是从上往下执行。
 * 3.如果在try-catch里面，出现了异常代码。 这时候JVM还是会收集异常信息。封装到对象里面
 * 4.往上抛。但是这次是先抛给catch。 如果catch能抓就抓，抓不到怎么办===》 JVM自己的处理机制兜底。
 *
 * @author Common-zhou
 * @since 2024-03-19 11:02
 */
public class Demo5 {

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

        try {
            String s = null;
            s.length();
        } catch (NullPointerException e) {
            System.out.println("出现了空指针");
        }

        System.out.println("test2 end");

    }
}
