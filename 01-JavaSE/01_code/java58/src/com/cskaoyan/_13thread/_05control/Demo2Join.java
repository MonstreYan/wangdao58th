package com.cskaoyan._13thread._05control;

import java.util.concurrent.TimeUnit;

/**
 * void join()        等待该线程终止。
 * 谁等待?
 * 执行结果上看main线程在等待, join这行代码在哪个线程上运行, 哪个线程等待
 *
 *
 * 当前正在执行哪个线程。 调用另外一个线程的join。就是当前线程，等到调用join的线程执行结束。
 *
 * @author Common-zhou
 * @since 2024-03-22 11:13
 */
public class Demo2Join {
    public static void main(String[] args) throws InterruptedException {

        // 当前正在执行哪个线程。 调用另外一个线程的join。就是当前线程，等到调用join的线程执行结束。 再往下执行。

        JoinThread joinThread = new JoinThread();

        joinThread.start();

        joinThread.join();

        System.out.println(Thread.currentThread().getName() + "===> start");
        System.out.println(Thread.currentThread().getName() + "===> end");


    }
}

class JoinThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "===>" + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
