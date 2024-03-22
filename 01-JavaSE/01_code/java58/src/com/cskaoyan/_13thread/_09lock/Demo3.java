package com.cskaoyan._13thread._09lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁。
 * 假设现在，我把锁拿着。 等会又进入了一个方法，这时候又要拿锁。
 * 该让我拿锁，不该让我拿锁。
 * <p>
 * //  oooooooo
 * // 可重入锁。 可重复拿到这把锁。 一定是同一个人。
 *
 * @author Common-zhou
 * @since 2024-03-22 17:16
 */
public class Demo3 {

    public static void main(String[] args) {

        // 可重入锁。就是对于一把锁， 如果持有的人，现在还持有锁。这时候再去拿这把锁，这把锁还是能拿到锁。
        // 里面有个计数器。 你lock了几次，就得unlock几次。

        // synchronized 也是个可重入锁。

        Lock lock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("线程开始执行了");

                lock.lock();

                System.out.println("before enter test2 method");
                test2();
                System.out.println("after enter test2 method");

                lock.unlock();

            }

            public void test2() {
                lock.lock();

                System.out.println("enter test2 method");

                lock.unlock();
                System.out.println("left test2 method");
            }

        }).start();
    }

}
