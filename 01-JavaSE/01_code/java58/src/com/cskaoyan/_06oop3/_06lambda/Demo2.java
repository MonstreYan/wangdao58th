package com.cskaoyan._06oop3._06lambda;

/**
 * @author Common-zhou
 * @since 2024-03-14 14:49
 */
public class Demo2 {

}


// FunctionalInterface里面，要求有且仅有一个必须要实现的抽象方法。
// 但是，并不意味着，只有一个方法。 因为静态方法和默认方法，不需要实现
@FunctionalInterface
interface Play2 {
    void play();
    default void play2(){

    }

    boolean equals(Object obj);
}
