package com.cskaoyan._13thread._08sync;

/**
 * synchronized 可以放在很多地方
 * 1.代码块上。
 * 对象  synchronized(obj){}  ==》 obj
 * class文件  synchronized(User.class)  ==> User.class
 * <p>
 * 2. 可以放在方法上面
 * private synchronized void  test1(){}   ===> this
 *
 * <p>
 * 3.可以放在静态方法上面。
 * private static synchronized void  test2(){}   ===> class文件
 * <p>
 * 关于这块，主要要研究一个问题。 锁的对象是谁。
 * 一定要知道锁的对象是谁。
 * <p>
 * 什么叫做锁对象：一个唯一资源。 多个线程争夺的资源。
 *
 * @author Common-zhou
 * @since 2024-03-22 16:02
 */
public class Demo4 {

}
