package com.cskaoyan._13thread._02implone;

/**
 * @author Common-zhou
 * @since 2024-03-21 17:54
 */
public class Demo5 {
    public static void main(String[] args) {
        MyThread4 myThread4 = new MyThread4();

        myThread4.start();
        // 不能启动多次, java.lang.IllegalThreadStateException
        myThread4.start();
    }
}
