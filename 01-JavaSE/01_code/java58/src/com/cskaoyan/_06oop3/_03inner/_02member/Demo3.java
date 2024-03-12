package com.cskaoyan._06oop3._03inner._02member;

/**
 * - 内部类可以继承和实现外部的类和接口。
 * - 也可以在类中定义多个普通类、抽象内部类和接口用来自己继承和实现。
 *
 * @author Common-zhou
 * @since 2024-03-12 16:21
 */
public class Demo3 {

}

interface Play3 {

}

class OuterClazz3 {

    class InnerClazz31 {
    }

    class InnerClazz32 extends InnerClazz31 {
    }

    class InnerClazz3 extends Demo3 implements Play3 {

    }


}
