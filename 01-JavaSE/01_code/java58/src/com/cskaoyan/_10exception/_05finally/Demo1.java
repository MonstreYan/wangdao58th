package com.cskaoyan._10exception._05finally;

/**
 * @author Common-zhou
 * @since 2024-03-19 14:53
 */
public class Demo1 {
    public static void main(String[] args) {
        // final  finally  finalize

        // finally： 就是在try中，一定会执行的代码。
        // 一般用于一些资源释放。
        // 不要在这里面搞其他的。不要在这里面写其他的业务代码逻辑。  因为水太深，把握不住。

        try {
            System.out.println("execute test1 before");
            test1(4);
            System.out.println("execute test1 after");
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
            e.printStackTrace();
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            System.out.println("其他异常");
            e.printStackTrace();
        } finally {
            System.out.println("这是finally里面的代码");
        }

        // 在一些异常输出的时候，顺序会有所差别。


    }

    private static void test1(int num) {

        // 在源码的内部，它也是这么抛出这个异常。
        if (num == 1) {
            throw new NullPointerException();
        } else if (num == 2) {
            throw new IllegalArgumentException();
        } else if (num == 3) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            throw new RuntimeException();
        }
    }
}
