package com.cskaoyan._02method._02define;

import java.util.Scanner;

/**
 * @author Common-zhou
 * @since 2024-03-01 15:26
 */
public class Demo3 {
    public static void main(String[] args) {
        // 2. 键盘录入两个值，求最大值。

        // 在Java里面，方法的主入口是main方法，所有方法，要么直接在main方法中调用，要么间接调用
        // 为什么要抽方法。就是方法是对代码的一个封装。  一个复用
        // 主要就是完成对代码的复用。 不用每一次都copy代码。
        System.out.println("inputTwoValueAndReturnMaxValue() = " + inputTwoValueAndReturnMaxValue());

        System.out.println("inputTwoValueAndReturnMaxValue() = " + inputTwoValueAndReturnMaxValue());

    }

    // 修饰符列表  返回值类型 方法名(形参列表){}
    // 见名知意：
    // public static int max() {
    public static int inputTwoValueAndReturnMaxValue() {
        // 上了一门英语课。      ==》 方法名字特别长。
        // 在企业里面，别人不怕名字长，就怕不认识。
        // i j k  a b c
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个值：");
        int inputValue1 = scanner.nextInt();
        System.out.println("请输入第二个值：");
        int inputValue2 = scanner.nextInt();

        return inputValue1 > inputValue2 ? inputValue1 : inputValue2;
    }


}
