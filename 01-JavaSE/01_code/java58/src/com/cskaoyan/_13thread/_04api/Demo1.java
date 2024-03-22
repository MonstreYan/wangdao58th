package com.cskaoyan._13thread._04api;


/**
 * 设置/获取线程的名字。
 *
 * @author Common-zhou
 * @since 2024-03-22 10:33
 */
public class Demo1 {
    public static void main(String[] args) {
        // String  getName()   返回该线程的名称。
        // static Thread    currentThread()     返回对当前正在执行的线程对象的引用。
        // void  setName(String name)      改变线程名称，使之与参数 name 相同。

        MyThread myThread = new MyThread();
        // myThread.setName("王道景天");
        // myThread.setName("王道吴彦祖");
        myThread.start();

        // 线程名如果在不设置的请款修改。 从0开始。 Thread-0 Thread-1

        MyThread myThread2 = new MyThread();
        myThread2.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start");
        System.out.println(Thread.currentThread().getName() + " end");
    }
}
