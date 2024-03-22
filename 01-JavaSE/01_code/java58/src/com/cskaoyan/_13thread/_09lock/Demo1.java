package com.cskaoyan._13thread._09lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized 其实是一个隐式锁。 加锁和去锁的过程，我们看不到。
 * synchronized(this){
 * <p>
 * }
 * <p>
 * Lock就是显式锁。   程序员可以手动控制加锁和去锁的逻辑。
 *
 * @author Common-zhou
 * @since 2024-03-22 17:03
 */
public class Demo1 {
    public static void main(String[] args) {
        // java.util.concurrent  ==> juc
        // Java里面的很多，并发编程相关的东西，全放在juc里面

        // 这个就是它提供的子实现类。   可重入锁。
        Lock lock = new ReentrantLock();

        // lock.lock();
        // lock.tryLock()


        // JUC    JVM
    }
}
