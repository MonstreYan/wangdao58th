package com.cskaoyan._13thread._08sync;

import java.util.concurrent.TimeUnit;

/**
 * @author Common-zhou
 * @since 2024-03-22 16:35
 */
public class Demo8 {


    public static void main(String[] args) throws InterruptedException {

        final Object object = new Object();


        Thread t1 = new Thread(() -> {
            System.out.println("A线程开始执行");

            synchronized (object) {
                System.out.println("A线程抢到锁了");

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("A代码块执行完了。锁丢掉");
            }

            System.out.println("A线程执行结束");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("B线程开始执行");
            System.out.println("B线程开始执行1");
            System.out.println("B线程开始执行2");
            System.out.println("B线程开始执行3");
            System.out.println("B线程开始执行4");
            System.out.println("B线程开始执行5");
            System.out.println("B线程开始执行6");

            synchronized (object) {
                System.out.println("B线程抢到锁了");
            }

            System.out.println("B线程执行结束");
        });

        t1.start();
        TimeUnit.MILLISECONDS.sleep(500);
        t2.start();

        // 凡是要进入synchronied 代码块，就要抢到锁。 如果这把锁被别人拿着，它就等着。 等到别人把锁丢掉，才能拿到这把锁。
        // 再进入 synchronized 代码块中执行代码。


    }

}
