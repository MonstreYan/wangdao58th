package com.cskaoyan._13thread._05control;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 线程休眠sleep
 *
 * @author Common-zhou
 * @since 2024-03-22 11:04
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        // static void sleep(long millis)
        // 在指定的毫秒数内让当前正在执行的线程休眠（暂停执行），此操作受到系统计时器和调度程序精度和准确性的影响。

        System.out.println("main start");

        Thread.sleep(5000);

        System.out.println("main end");

        new MyThread1().start();

    }

    @Test
    public void test1() throws InterruptedException {
        // 当做主方法用。
        // 在多线程的时候。不要用 @Test

        new MyThread1().start();

        TimeUnit.SECONDS.sleep(8);

        // 因为 @Test 其实也是个线程在运行它。 但是这个线程不等其他线程执行完。 它执行完了就完了。

    }

}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "===>" + i);

            // TimeUnit.SECONDS.sleep(5);
            // Thread.sleep(1000);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
