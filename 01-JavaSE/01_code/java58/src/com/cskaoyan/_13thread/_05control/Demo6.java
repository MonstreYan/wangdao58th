package com.cskaoyan._13thread._05control;

/**
 * 理论层面的状态
 * 新建
 * - 刚new出来的线程对象
 * 就绪
 * - 线程执行了start()方法后
 * 执行
 * - 拥有CPU的执行权
 * 阻塞
 * - 线程会处于阻塞状态
 * 死亡
 * - run方法执行完
 *
 * @author Common-zhou
 * @since 2024-03-22 11:37
 */
public class Demo6 {


    public static void main(String[] args) {
        // 目前处于新建状态。 刚刚 new出来这个对象
        MyThread1 myThread1 = new MyThread1();

        // 开启了多线程。 ===》 就绪状态
        myThread1.start();

        // 阻塞状态： 有一些资源不满足的时候，处于阻塞状态。

        // 死亡。



    }

}
