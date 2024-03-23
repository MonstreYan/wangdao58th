package com.cskaoyan._13thread._13wait_notify;

/**
 * A  1 3 5 7 9
 * B 2 4 6 8 10
 * 一直打印到100. 交替打印。
 *
 * @author Common-zhou
 * @since 2024-03-23 11:12
 */
public class Demo3 {
    public static void main(String[] args) {
        // wait  notify
        Object object = new Object();

        new Thread(() -> {

            synchronized (object) {
                for (int i = 1; i <= 100; i += 2) {
                    object.notify();
                    // 1 3 5 7
                    System.out.println(i);

                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                // object.notify();
            }

        }).start();


        new Thread(() -> {
            synchronized (object) {
                for (int i = 2; i <= 100; i += 2) {

                    object.notify();

                    System.out.println(i);

                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                // object.notify();
            }
        }).start();
    }

}
