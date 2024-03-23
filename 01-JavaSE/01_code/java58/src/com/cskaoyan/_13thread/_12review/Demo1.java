package com.cskaoyan._13thread._12review;

/**
 * 多线程实现方式2：
 * 1.实现Runnable接口
 * 2.重写run方法
 * 3.创建子类对象
 * 4.创建线程  new Thread(传入子类对象)
 * 5.调用start方法。
 *
 * @author Common-zhou
 * @since 2024-03-23 09:39
 */
public class Demo1 {
    public static void main(String[] args) {
        // 3.创建子类对象
        MyRunnable myRunnable = new MyRunnable();

        // 4.创建线程  new Thread(传入子类对象)
        Thread thread = new Thread(myRunnable);

        // 5.调用start方法。
        thread.start();


        // 实现方式2，衍生出了很多新建线程的方式。

        // lambda
        // 匿名内部类对象

        // 匿名内部类对象。  ====》 创建出来就是个对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "===> start");
                System.out.println(Thread.currentThread().getName() + "===> end");
            }
        }).start();

        // 2.lambda表达式的方式
        // (形参) ->{逻辑}
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "===> start");
            System.out.println(Thread.currentThread().getName() + "===> end");
        }).start();


    }
}


// 1.实现Runnable接口
class MyRunnable implements Runnable {

    // 2.重写run方法
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "===> start");
        System.out.println(Thread.currentThread().getName() + "===> end");
    }
}
