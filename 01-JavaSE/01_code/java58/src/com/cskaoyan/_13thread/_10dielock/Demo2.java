package com.cskaoyan._13thread._10dielock;

import java.util.concurrent.TimeUnit;

/**
 * 1.将拿锁的顺序固定化
 *
 * @author Common-zhou
 * @since 2024-03-22 17:24
 */
public class Demo2 {

    public static void main(String[] args) {
        MyDieLockThread2 myDieLockThread1 = new MyDieLockThread2(true);
        MyDieLockThread2 myDieLockThread2 = new MyDieLockThread2(true);

        myDieLockThread1.start();
        myDieLockThread2.start();
    }
}

class MyDieLockThread2 extends Thread {
    private static final Object LOCK_A = new Object();
    private static final Object LOCK_B = new Object();


    public MyDieLockThread2(boolean firstGetALock) {
    }

    @Override
    public void run() {

        synchronized (LOCK_A) {
            System.out.println(Thread.currentThread().getName() + "===> get A lock");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (LOCK_B) {
                System.out.println(Thread.currentThread().getName() + "===> get B lock");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }


    }
}

