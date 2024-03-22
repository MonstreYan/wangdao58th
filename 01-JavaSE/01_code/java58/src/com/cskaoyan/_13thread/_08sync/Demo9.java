package com.cskaoyan._13thread._08sync;

import java.util.concurrent.TimeUnit;

/**
 * @author Common-zhou
 * @since 2024-03-22 16:44
 */
public class Demo9 {
    private static final Object OBJECT = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {

            synchronized (OBJECT) {
                int count = 0;
                while (true) {
                    // 在里面写了一个死循环
                    System.out.println("A正在执行， count=" + count);
                    count++;

                    // 循环1次，睡1s。
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    if (count == 5) {
                        // 如果count为5，则认为抛出异常
                        throw new RuntimeException("异常了");
                    }
                }
            }

        }, "A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            System.out.println("B线程开始执行了========");
            synchronized (OBJECT) {
                System.out.println("B拿到锁了");
            }
        }).start();
    }
}
