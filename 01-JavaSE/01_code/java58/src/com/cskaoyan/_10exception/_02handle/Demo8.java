package com.cskaoyan._10exception._02handle;

/**
 * 如果说，在多catch分支的情况下，如果不同的catch分支，处理的异常类型，有父子关系
 * 那么就一定要注意，处理子类的异常分支写在前面，父类的异常分支写在后面
 *
 * @author Common-zhou
 * @since 2024-03-19 11:32
 */
public class Demo8 {

    public static void main(String[] args) {

        // try-catch中可以有多个catch。 只会进入其中一个catch， 或者不进入。
        // 一定顶多进入一个。

        // 1.如果多catch分支中，异常有父子继承关系。这时候，父类一定要放在下面。
        // 因为，父类放在上面。异常肯定会被上面抓掉，不会进入下面。
        try {
            test1(1);
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("算术异常");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("出现了Exception");
            e.printStackTrace();
        }

    }

    private static void test1(int num) {

        if (num == 0) {
            int i = 1 / 0;
        } else if (num == 1) {
            String s = null;
            s.length();
        }

    }

}
