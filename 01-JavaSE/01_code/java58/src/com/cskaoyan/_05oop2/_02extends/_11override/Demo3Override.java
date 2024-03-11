package com.cskaoyan._05oop2._02extends._11override;

/**
 * `@Override` 注解 这个注解，用于写在子类上面，用于检测。该方法，是否为重写了父类的方法。
 * Override只做一个事，就是检测这个方法， 到底是不是重写了父类的方法
 * 如果不是，直接报错。
 * <p>
 * Override 有什么好处：
 * 可以让程序帮你去检测是否重写。 减少很多不必要的麻烦
 *
 * @author Common-zhou
 * @since 2024-03-11 11:18
 */
public class Demo3Override {

}


class Father3 {
    public void test1() {

    }

    public void test1DefaultTest2MethodTest3Method() {

    }
}

class Son3 extends Father3 {
    // Method does not override method from its superclass
    @Override
    public void test1() {
        System.out.println("test1");
    }

    @Override
    public void test1DefaultTest2MethodTest3Method() {
        // 父类和子类，都有这个方法。
    }
}
