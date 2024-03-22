package com.cskaoyan._13thread._09lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock 接口。来完成 累加计数的工作。
 * 5个线程，同时对一个数进行累加。 最终输出结果
 *
 * @author Common-zhou
 * @since 2024-03-22 17:08
 */
public class Demo2 {
    public static void main(String[] args) {

        IncreRunnable increRunnable = new IncreRunnable();
        Thread t1 = new Thread(increRunnable);
        Thread t2 = new Thread(increRunnable);
        Thread t3 = new Thread(increRunnable);
        Thread t4 = new Thread(increRunnable);
        Thread t5 = new Thread(increRunnable);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}


class IncreRunnable implements Runnable {

    private int count = 0;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        // 锁一定要完全保证，一定能丢掉
        for (int i = 0; i < 100000; i++) {

            lock.lock();
            try {
                count++;
            } finally {
                // 到这还有没有锁。
                lock.unlock();
            }

        }

        System.out.println(Thread.currentThread().getName() + "===>" + count);

    }
}
