package com.cskaoyan._13thread._06impltwo;

/**
 * 1.创建类，实现Runnable接口
 * 2.重写run方法
 * 3.创建子类对象
 * 4.创建线程对象。把子类对象作为参数传递
 * 5.start
 *
 * @author Common-zhou
 * @since 2024-03-22 11:52
 */
public class Demo2 {
    public static void main(String[] args) {
        MyRunnable2 myRunnable2 = new MyRunnable2();

        Thread thread1 = new Thread(myRunnable2);

        thread1.start();

        // 内部类。匿名内部类，lambda
        // 在不同的位置，定义类的。

        Runnable runnableRun = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable run");
            }
        };


        Thread thread11 = new Thread(runnableRun);
        thread11.start();


    }
}

class MyRunnable2 implements Runnable {

    @Override
    public void run() {
        System.out.println("MyRunnable2 start");
        System.out.println("MyRunnable2 end");
    }
}
