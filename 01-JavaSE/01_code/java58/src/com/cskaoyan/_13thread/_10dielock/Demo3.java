package com.cskaoyan._13thread._10dielock;

import java.util.concurrent.TimeUnit;

/**
 * 方式2： 再拿锁之前，先拿一把公共的锁。
 * @author Common-zhou
 * @since 2024-03-22 17:42
 */
public class Demo3 {
    public static void main(String[] args) {
        MyThreadDieLock3Thread lockThrea1 = new MyThreadDieLock3Thread(true);
        MyThreadDieLock3Thread lockThrea2 = new MyThreadDieLock3Thread(false);
        lockThrea1.start();
        lockThrea2.start();

    }
}

class MyThreadDieLock3Thread extends Thread {
    private static final Object LOCK_A = new Object();
    private static final Object LOCK_B = new Object();

    private static final Object LOCK_C = new Object();


    boolean firstGetALock;

    public MyThreadDieLock3Thread(boolean firstGetALock) {
        this.firstGetALock = firstGetALock;
    }

    @Override
    public void run() {

        if (firstGetALock) {

            synchronized (LOCK_C) {


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
            }

        } else {
            synchronized (LOCK_C) {
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

}
