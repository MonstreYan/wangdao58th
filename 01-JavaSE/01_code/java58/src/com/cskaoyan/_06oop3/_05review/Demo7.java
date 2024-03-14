package com.cskaoyan._06oop3._05review;

/**
 * @author Common-zhou
 * @since 2024-03-14 11:34
 */
public class Demo7 {
    public static void main(String[] args) {
        // 多态，在Java中就是指的，用父类引用，指向子类对象。
        // 子类对象是谁，最终，方法的调用就是谁的方法

        // 编译看左边，运行看右边
        Phone phone = new HuaweiPhone();

        phone.call();
        // phone


    }
}

class Phone {
    void call() {
        System.out.println("打电话");
    }
}


class Iphone extends Phone {
    @Override
    void call() {
        System.out.println("iphone打电话");
    }


}

class HuaweiPhone extends Phone {
    @Override
    void call() {
        System.out.println("华为手机打电话");
    }

    public void satelliteCommunication() {
        System.out.println("卫星通讯");
    }
}
