package com.cskaoyan._13thread._08sync;

import java.util.concurrent.TimeUnit;

/**
 * @author Common-zhou
 * @since 2024-03-22 16:12
 */
public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        MyThread5 myThread51 = new MyThread5();
        MyThread5 myThread52 = new MyThread5();

        myThread51.start();

        TimeUnit.MILLISECONDS.sleep(300);
        myThread52.start();
    }
}


class MyThread5 extends Thread {
    @Override
    public void run() {
        // synchronized (this) {
        synchronized (MyThread5.class) {
            System.out.println(Thread.currentThread().getName() + "===> start");

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "===> end");
        }
    }
}
