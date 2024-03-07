package com.cskaoyan._04oop1._13package;

/**
 * 全限定类名： 就是包名+类名 可以唯一定位到一个类的字符串。
 * 这个就是全限定类名。 com.cskaoyan._04oop1._13package.Demo3
 * 默认情况下。 我们打印这个对象的引用，就会打印出来它的全限定类名
 *
 * @author Common-zhou
 * @since 2024-03-07 17:03
 */
public class Demo3 {
    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();

        // com.cskaoyan._04oop1._13package.Demo3@6d311334
        // 全限定类名 @  地址
        System.out.println(demo3);
    }
}
