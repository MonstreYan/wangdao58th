package com.cskaoyan._05oop2._02extends._12final;

/**
 * 形参用final修饰后，不是表示该方法只能传入常量，而是实参一旦传入后就无法在方法体中修改了。
 *
 * @author Common-zhou
 * @since 2024-03-11 15:03
 */
public class Demo6 {

    public void test1(final int num) {
        // 只是代表 num这个变成了常量，无法再方法中进行修改。
        System.out.println(num);


        // 在这不能改num
        // num = 10;
    }


    public static void main(String[] args) {
        // 变量
        int num = 20;

        new Demo6().test1(num);
    }
}
