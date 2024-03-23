package com.cskaoyan._13thread._12review;

/**
 * Java里面的锁： 就是依赖于一个关键字 synchronized
 * <p>
 * synchronized可以放在三个地方
 * 1.代码块上
 * synchronized(obj){
 * <p>
 * }
 * <p>
 * 2.方法上面 ==> 锁就是 this
 * <p>
 * public synchronized void test1(){}
 * <p>
 * 3.静态方法上面  ===》 锁就是 class文件（当前的类文件）
 *
 * @author Common-zhou
 * @since 2024-03-23 09:59
 */
public class Demo2 {

    public synchronized void test1() {
        test2();
    }

    public synchronized void test2() {
        System.out.println("==============");
    }
}
