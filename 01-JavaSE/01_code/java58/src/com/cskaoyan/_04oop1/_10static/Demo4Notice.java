package com.cskaoyan._04oop1._10static;

/**
 * @author Common-zhou
 * @since 2024-03-07 11:14
 */
public class Demo4Notice {
    public static void main(String[] args) {
        // 只存在静态成员变量，不存在"静态局部变量"

        // 成员变量： 在类中、方法外。 这个叫成员变量
        // 静态成员变量： 成员变量 + static
        // 局部变量： 在局部的变量。  在方法内的变量， 或者说在方法形参位置的变量
        // Modifier 'static' not allowed here  ==》 static不允许放这。
        /*static*/ int a = 10;

    }
}
