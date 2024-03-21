package com.cskaoyan._13thread._02implone;

import java.util.concurrent.TimeUnit;

/**
 * start方法跟run方法有什么区别?
 * - start方法才是开辟新的执行路径, run方法只是普通方法调用, 并没有开辟新的执行路径,
 * 还是一条执行路径, 仍然是单线程的.
 *
 * @author Common-zhou
 * @since 2024-03-21 17:49
 */
public class Demo4 {
    public static void main(String[] args) {
        MyThread4 myThread4 = new MyThread4();

        System.out.println("main run before start");
        // myThread4.run();
        myThread4.start();
        System.out.println("main  run after start");

    }
}

class MyThread4 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " end");
    }
}
