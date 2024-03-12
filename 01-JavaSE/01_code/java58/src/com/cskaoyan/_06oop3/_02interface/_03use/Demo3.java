package com.cskaoyan._06oop3._02interface._03use;

/**
 * 语法不难。 这玩意到底是干啥的？
 * 接口的作用，是定义规范。
 * <p>
 * 接口的子类，可以有哪些东西？
 * 1.普通类，可以。 但是普通类必须实现接口中的所有方法。
 * 2.抽象类。可以。 而且可以按需实现抽象方法，可以实现，也可以不实现、
 * 3.接口。可以。这时候需要使用extends关键字。 可以在这里面，继续添加方法
 *
 * @author Common-zhou
 * @since 2024-03-12 11:40
 */
public class Demo3 {

}

interface Fly3 {
    void fly();
}

class Sparrow3 implements Fly3 {

    @Override
    public void fly() {

    }
}

abstract class AbstractSparrow3 implements Fly3 {
    @Override
    public void fly() {
        System.out.println("AbstractSparrow3");
    }
}


interface FlyImprove extends Fly3 {

}
