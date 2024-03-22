package com.cskaoyan._13thread._06impltwo;

/**
 * @author Common-zhou
 * @since 2024-03-22 14:48
 */
public class Demo4 {
    public static void main(String[] args) {
        // 为什么Runnable接口里面的run方法，会被调用。


        // 1.我们传入的 target。最终存储到了成员变量 target里面
        //  this.target = target;
        // 2.我们重写了run方法。
        // 发现，在Thread的run方法中。调用了 target.run()
        // 所以start的时候。才用的是 传入的Runnable里面的run方法。

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "===> start");
                System.out.println(Thread.currentThread().getName() + "===> end");
            }
        }).start();

        // 多态。

    }
}
