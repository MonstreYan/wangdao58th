package com.cskaoyan._13thread._05control;

/**
 * static void yield()        暂停当前正在执行的线程对象，并执行其他线程。
 * 让出CPU执行权。 我再接着抢。
 * 有可能能抢到。
 *
 *
 * 在多线程的面试，最喜欢问的一个编程题。    俩线程A打印1.B打印2 A打印3
 *
 *
 *
 *
 * @author Common-zhou
 * @since 2024-03-22 11:20
 */
public class Demo3 {
    public static void main(String[] args) {

        YieldThread yieldThread1 = new YieldThread();
        YieldThread yieldThread2 = new YieldThread();

        yieldThread1.start();
        yieldThread2.start();

    }
}

class YieldThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "===>" + i);
            Thread.yield();
        }
    }
}
