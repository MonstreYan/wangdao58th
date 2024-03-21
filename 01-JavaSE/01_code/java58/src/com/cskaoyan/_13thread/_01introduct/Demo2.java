package com.cskaoyan._13thread._01introduct;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 多线程就是，可以让同一时刻，有多个执行路径
 *
 * @author Common-zhou
 * @since 2024-03-21 17:16
 */
public class Demo2 {
    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        sayHello();

        waitUserInputEnd();
    }

    private static void waitUserInputEnd() {

        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);

            String inputStr = scanner.nextLine();

            if ("end".equals(inputStr)) {
                flag = false;
            }
        }).start();

    }

    private static void sayHello() throws InterruptedException {
        new Thread(() -> {
            while (flag) {
                System.out.println("你好");

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
