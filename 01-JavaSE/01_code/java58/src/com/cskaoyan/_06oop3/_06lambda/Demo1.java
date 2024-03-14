package com.cskaoyan._06oop3._06lambda;

/**
 * Lambda表达式虽然说是取代接口的匿名内部类，但也不是什么接口都能用Lambda表达式创建子类对象。
 * <p>
 * Lambda表达式要求的接口中，必须有且仅有一个必须要实现的抽象方法。
 * 这种接口在Java中，被称之为"功能接口"。功能接口在语法上，
 * 可以使用注解@FunctionalInterface标记在接口头上，用于检测一个接口是否是功能接口。
 *
 * @author Common-zhou
 * @since 2024-03-14 14:40
 */
public class Demo1 {
    static class Play1Impl2 implements Play1 {
        @Override
        public void play() {

        }
    }

    public static void main(String[] args) {
        // lambda表达式： 是一个特殊的局部内部类。 它主要的目的是取代匿名内部类。

        // 现在想写一个Play1的子类对象，有几种方式
        // 1.在外面写。  new Play1Impl();
        // 2.静态内部类。
        // 3.局部内部类
        class Play1Impl3 implements Play1{

            @Override
            public void play() {

            }
        }
        new Play1Impl3();

        // 匿名内部类的方式。
        // Anonymous new Play1() can be replaced with lambda
        Play1 play1 = new Play1(){

            @Override
            public void play() {

            }
        };

        // 这个就叫做lambda表达式。 它是专门用来替代匿名内部类的。
        // 但是也不是所有的都能替代。
        // 前提： 是接口中有且仅有一个待实现的方式。
        Play1 play2 = () -> {

        };


    }
}

// Multiple non-overriding abstract methods found in interface com.cskaoyan._06oop3._06lambda.Play1
@FunctionalInterface
interface Play1 {
    void play();
}

class Play1Impl implements Play1 {

    @Override
    public void play() {

    }
}
