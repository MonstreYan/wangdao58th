package com.cskaoyan._02method._02define;

/**
 * * 3. 定义一个方法用于判断一个正整数的奇偶性，要求：
 * * 1. 奇数方法返回false
 * * 2. 偶数方法返回true
 *
 * @author Common-zhou
 * @since 2024-03-01 15:52
 */
public class Demo4 {
    // [修饰符列表] 返回值类型 方法名(形参列表){
    // // 方法体。 也就是方法的具体逻辑
    // }
    // 词典搜索一下。
    // ChatGPT
    // 要清晰，明了的表明自己的需求。
    // 1.现在，我是一个Java程序员。 我需要你帮我取一个方法的名字。这个方法的主要正作用是判断一个正整数的奇偶性。
    // 2.现在，我想写一个代码。 代码的主要作用是判断正整数的奇偶性。偶数返回true， 奇数返回false。使用Java代码。
    // 最好帮我写成一个 public static 的方法。 方法的名字叫做isNumberEven

    // ChatGPT 有一定的概率出错。 一本正经的胡说八道。    要能区分出来它说的是对是错。
    public static boolean isNumberEven(int numer) {
        if (numer % 2 == 0) {
            return true;
        }

        return false;
    }

}
