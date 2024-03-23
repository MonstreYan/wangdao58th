package com.cskaoyan._13thread._13wait_notify;

/**
 * wait 和 notify
 * wait就是让当前线程等待。
 * notify就是通知其他线程。
 *
 * @author Common-zhou
 * @since 2024-03-23 10:58
 */
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        // wait和notify一定要在锁的代码中运行，如果在外面单独运行会报错。
        Object o = new Object();

        // IllegalMonitorStateException
        // o.wait();

        // IllegalMonitorStateException
        o.notify();
    }
}
