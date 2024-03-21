package com.cskaoyan._13thread._02implone;

import java.util.concurrent.TimeUnit;

/**
 * 多线程的实现方式1： 继承Thread类
 * <p>
 * 1. 定义一个类继承Thread类
 * 2. 重写run方法
 * 3. 创建子类对象
 * 4. 通过start方法启动线程
 *
 * @author Common-zhou
 * @since 2024-03-21 17:36
 */
public class Demo1 {

    public static void main(String[] args) {
        // 3. 创建子类对象
        MyThread1 myThread1 = new MyThread1();

        //  4. 通过start方法启动线程
        myThread1.start();

        System.out.println("main end");
    }


}

class MyThread1 extends Thread {
    @Override
    public void run() {
        // 重写run方法。 run方法里面的逻辑，就是你想要多线程实现的逻辑
        System.out.println("MyThread1 start");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("MyThread1 end");

    }
}
