package com.cskaoyan._06oop3._05review;

/**
 * @author Common-zhou
 * @since 2024-03-14 11:42
 */
public class Demo8 {
    public static void main(String[] args) {
        Play1 play1 = new Play1Impl();

        // 父类引用指向子类对象。
        // 编译看左边，运行看右边。====》 多态存在
        play1.play1();

        play1.play2();

        // 接口和抽象类都符合多态。  编译看左边，运行看右边。
    }
}

interface Play1 {
    void play1();

    void play2();
}

class Play1Impl implements Play1 {

    @Override
    public void play1() {
        System.out.println("Play1Impl play11111111111");
    }

    @Override
    public void play2() {
        System.out.println("Play1Impl play2222222222222222");
    }
    public void play3() {
        System.out.println("Play1Impl play3");
    }
}
