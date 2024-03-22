package com.cskaoyan._13thread._10dielock;

import java.util.concurrent.TimeUnit;

/**
 * 2个或以上线程因为争抢资源而造成的互相等待的现象
 *
 * 死锁的解决方法：
 * 1.将拿锁的顺序固定化
 * 2.先拿一把更大的锁，拿到了才能拿这俩锁。
 *
 * @author Common-zhou
 * @since 2024-03-22 17:24
 */
public class Demo1 {

    public static void main(String[] args) {
        MyDieLockThread myDieLockThread1 = new MyDieLockThread(true);
        MyDieLockThread myDieLockThread2 = new MyDieLockThread(false);

        myDieLockThread1.start();
        myDieLockThread2.start();
    }
}

class MyDieLockThread extends Thread {
    private static final Object LOCK_A = new Object();
    private static final Object LOCK_B = new Object();


    boolean firstGetALock;

    public MyDieLockThread(boolean firstGetALock) {
        this.firstGetALock = firstGetALock;
    }

    @Override
    public void run() {

        if (firstGetALock) {
            synchronized (LOCK_A) {
                System.out.println(Thread.currentThread().getName() + "===> get A lock");

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (LOCK_B) {
                    System.out.println(Thread.currentThread().getName() + "===> get B lock");
                }
            }
        } else {
            synchronized (LOCK_B) {
                System.out.println(Thread.currentThread().getName() + "===> get B lock");

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (LOCK_A) {
                    System.out.println(Thread.currentThread().getName() + "===> get A lock");
                }
            }
        }

    }
}

