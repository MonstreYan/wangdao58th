package com.cskaoyan._13thread._05control;

/**
 * @author Common-zhou
 * @since 2024-03-22 11:41
 */
public class Demo7 {
    public static void main(String[] args) {
        // - NEW
        // 至今尚未启动的线程处于这种状态。
        MyThread1 myThread1 = new MyThread1();

        // - RUNNABLE
        // 正在  Java 虚拟机中执行的线程处于这种状态。

        myThread1.start();
        // 开启了线程之后。 我都处于执行状态。  （执行的时候是RUNNABLE 不执行的也是）

        // - BLOCKED  ===》 等锁。
        // 受阻塞并等待某个监视器锁的线程处于这种状态。
        // - WAITING
        // 无限期地等待另一个线程来执行某一特定操作的线程处于这种状态。
        // - TIMED_WAITING
        // 等待另一个线程来执行取决于指定等待时间的操作的线程处于这种状态。
        // - TERMINATED
        // 已退出的线程处于这种状态。

    }
}
