package com.cskaoyan._05oop2._02extends._12final;

import java.security.PublicKey;

/**
 * final修饰方法，表示最后的方法，最终的方法。 表示该方法无法被重写， 但是仍然可以被继承
 *
 * @author Common-zhou
 * @since 2024-03-11 14:34
 */
public class Demo3 {

}

class Father3 {
    public final void test1() {

    }

    public /*final*/ Father3() {

    }

    // 1. private方法，本来就无法重写，不需要多此一举。（可以修饰，但是会报警告）
    // 2. static方法，本来就无法重写，不需要多此一举。（可以修饰，但是会报警告）
    // 3. 构造方法，不能被继承，更不能重写，加final修饰会编译报错。

    private final void test2() {
    }

    public final static void test3() {
    }


}

class Son3 extends Father3 {
    // 在子类中，重写这个方法。   alt +enter
    // ctrl+o
    // 直接写方法的名字

    // 'test1()' cannot override 'test1()' in 'com.cskaoyan._05oop2._02extends._12final.Father3';
    // overridden method is final
    // @Override
    // public void test1() {
    //
    // }
}
