package com.cskaoyan._13thread._06impltwo;

import java.util.concurrent.TimeUnit;

/**
 * 1. 定义一个类实现Runnable接口
 * 2. 重写run方法
 * 3. 创建子类对象
 * 4. 创建线程对象, 把实现了Runnable接口的子类对象作为参数传递
 * 5. start方法启动线程
 *
 * @author Common-zhou
 * @since 2024-03-22 11:48
 */
public class Demo1 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        Thread thread1 = new Thread(myRunnable);

        thread1.start();

    }
}


class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "====>" + i);

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
