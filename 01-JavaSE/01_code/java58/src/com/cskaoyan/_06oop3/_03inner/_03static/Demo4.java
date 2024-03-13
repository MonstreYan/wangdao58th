package com.cskaoyan._06oop3._03inner._03static;

/**
 * 它其实就是一个独立的类。只是借助于外部类保护自己。 其余没什么区别。
 * <p>
 * 静态内部类的继承与实现和成员内部类并没有太大不同，区别在于，
 * 静态内部类只能继承一个静态内部类，而不能继承成员内部类。
 * 而且由于静态内部类的独立性很强，在外部，也可以在有权限的情况下，
 * 轻松继承一个静态内部类。
 * <p>
 * 静态内部类只能继承一个静态内部类，而不能继承成员内部类。：
 *
 * @author Common-zhou
 * @since 2024-03-13 09:53
 */
public class Demo4 {

}

class OuterClazz4 {
    class InnerClazz41 {
    }

    static class InnerClazzStatic1 {
    }

    // 静态内部类，可以继承其他的类。 但是对于成员内部类，不能继承。
    static class InnerClazz4 extends InnerClazzStatic1 {
    }

    static class InnerClazz42 extends Demo4 {
    }
}
