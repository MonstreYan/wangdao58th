package com.cskaoyan._06oop3._02interface._04default;

/**
 * 接口中的默认方法，还可以配合接口的"多实现"，实现真正意义上的多继承。
 * <p>
 * 可以使用默认方法的组合，来写方法。然后再配合实现多个接口。 这样类中多个都有了。
 *
 * @author Common-zhou
 * @since 2024-03-12 14:35
 */
public class Demo3 {

}

class Animal1 {
    public void test1() {
        System.out.println("test1");
    }
}

class Animal2 {
    public void test2() {
        System.out.println("test2");
    }
}


interface Play31 {
    default void test1() {
        System.out.println("test1");
    }
}

interface Play32 {
    default void test2() {
        System.out.println("test2");
    }
}


class SubAnimal2 extends Animal1 {

}

class SubAnimal3 implements Play31, Play32 {

}
