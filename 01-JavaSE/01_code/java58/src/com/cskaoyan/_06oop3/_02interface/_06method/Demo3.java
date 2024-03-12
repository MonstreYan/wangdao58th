package com.cskaoyan._06oop3._02interface._06method;

/**
 * 方法重写中的返回值类型问题
 * 方法重写， 方法重载。
 * final  finally fianlize
 * <p>
 * <p>
 * 1. 基本类型和void：必须保持一模一样，不存在类型提升。
 * 2. 引用类型：不必保持一模一样，存在自动向上转型。
 *
 * 这个其实是一个梳理。
 *
 * @author Common-zhou
 * @since 2024-03-12 15:21
 */
public class Demo3 {

}


class Animal3 {
    public int test1() {
        return 0;
    }

    public Animal1 test2() {
        return null;
    }
}

class Dog3 extends Animal3 {
    @Override
    public int test1() {
        return 1;
    }


    @Override
    public Cat1 test2() {
        return null;
    }
}
