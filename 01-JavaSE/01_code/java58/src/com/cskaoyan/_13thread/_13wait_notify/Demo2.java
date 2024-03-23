package com.cskaoyan._13thread._13wait_notify;

import java.util.concurrent.TimeUnit;

/**
 * wait用于让当前线程等待。并且丢掉锁。 直到别的线程通知的时候，才会继续执行。
 * 如果锁在别的线程那，它能不能继续走。一定要等到拿到锁，再接着走。
 * <p>
 * notify就是通知其他线程可以执行了。
 *
 * @author Common-zhou
 * @since 2024-03-23 11:02
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();

        // synchronized (object) {
        //     // object.wait();
        //
        //     object.notify();
        // }
        new Thread(() -> {
            System.out.println("A线程开始运行了");

            synchronized (object) {
                System.out.println("A线程拿到锁了");
                try {
                    TimeUnit.SECONDS.sleep(3);

                    // wait就是让当前线程等待。并且丢掉锁。
                    // 等到什么时候才会中止等待。 等notify的时候，才会继续执行
                    object.wait();

                    System.out.println("A wait下面的代码");

                    TimeUnit.SECONDS.sleep(60);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();

        TimeUnit.MILLISECONDS.sleep(300);
        new Thread(() -> {
            System.out.println("B线程开始运行了");

            synchronized (object) {
                System.out.println("B线程拿到锁了");

                object.notify();

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("B丢掉锁了");
            }
        }).start();


    }
}
