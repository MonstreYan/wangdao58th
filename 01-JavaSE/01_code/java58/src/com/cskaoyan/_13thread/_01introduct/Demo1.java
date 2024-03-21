package com.cskaoyan._13thread._01introduct;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 假如我要实现如下功能
 * 程序不停地在屏幕上输出一句问候的语句(比如“你好”)  3s输出一次
 * “同时”，当我通过键盘输入固定输入的时候，程序停止向屏幕输出问候的语句(比如说输入end)
 *
 * 单线程： 就是程序的执行是一条线。如果方法先调用 sayHello() 再调用 waitUserInputEnd
 * 一定要等到 sayHello() 方法执行结束之后。  waitUserInputEnd 这个才会开始运行。
 *
 *
 * @author Common-zhou
 * @since 2024-03-21 17:08
 */
public class Demo1 {

    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        sayHello();

        waitUserInputEnd();
    }

    private static void waitUserInputEnd() {

        Scanner scanner = new Scanner(System.in);

        String inputStr = scanner.nextLine();

        if ("end".equals(inputStr)) {
            flag = false;
        }

    }

    private static void sayHello() throws InterruptedException {
        while (flag) {
            System.out.println("你好");

            TimeUnit.SECONDS.sleep(3);
        }
    }

}
