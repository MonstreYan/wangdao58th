package com.cskaoyan._10exception._02handle;

/**
 * catch里面，一定要是所对应的对应的异常。或者说这个异常的父类也可以。，
 *
 * @author Common-zhou
 * @since 2024-03-19 11:09
 */
public class Demo6 {
    public static void main(String[] args) {
        test1(1);

        test1(0);
    }

    private static void test1(int num) {

        System.out.println("test1 start " + num);

        try {
            System.out.println("test1 divide before " + num);
            int i = 10 / num;
            System.out.println("test1 divide after " + num);
        }
        // catch (NullPointerException e) {
        //     System.out.println("出现了空指针");
        // }
        // catch里面，一定要是所对应的对应的异常。或者说这个异常的父类也可以。
        // catch (ArithmeticException e) {
        catch (Exception e) {
            System.out.println("算数异常");
        }

        System.out.println("test1 end " + num);
    }
}
