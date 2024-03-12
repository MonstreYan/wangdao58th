package com.cskaoyan._06oop3._02interface._04default;

/**
 * 在没有默认方法时，接口中一旦新增任何方法，子类都必须实现它。
 * 而现在有了默认方法，就不需要这么做：需要实现的就自己重写，不需要的就直接继承。代码的兼容性和灵活性就增加了。
 *
 * @author Common-zhou
 * @since 2024-03-12 14:33
 */
public class Demo2 {

}

interface Play2 {
    void play1();

    // void play2();

    default void play2() {
        System.out.println("这个是一个默认实现");
    }
}

class Play2Impl implements Play2 {
    @Override
    public void play1() {

    }

    @Override
    public void play2() {
        System.out.println("按照自己的方式来写。 ");
    }
}
