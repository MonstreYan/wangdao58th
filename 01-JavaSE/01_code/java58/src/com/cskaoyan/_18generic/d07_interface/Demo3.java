package com.cskaoyan._18generic.d07_interface;

import org.junit.Test;

/**
 * 泛型接口的泛型，在什么时候被固定下来。
 * 1.接口可以继承接口
 * 2.类可以实现接口
 * <p>
 * 在类实现接口的时候，泛型会被固定。
 *
 * @author Common-zhou
 * @since 2024-03-28 10:31
 */
public class Demo3 {

    @Test
    public void test1() {
        OldPlayer<String> oldPlayer = new OldPlayer<>();
        String play = oldPlayer.play("");

        OldPlayer<Integer> oldPlayer1 = new OldPlayer<>();
        // oldPlayer1.play()

        // Player<String> player = new OldPlayer<Integer>();
    }

}

// 泛型接口。
interface Player<T> {
    T play(T t);
}

// interface Player1 extends Player{}

// 情况1： 实现接口的时候，不指定泛型类型。这个时候，是默认类型。Object
class ChildPlayer implements Player {
    @Override
    public Object play(Object object) {
        return null;
    }
}


// 情况2： 实现接口的时候，指定泛型为固定类型。上面的方法，就是你指定的类型
class YoungPlayer implements Player<String> {
    @Override
    public String play(String s) {
        return null;
    }
}

//情况3： 实现接口的时候，子类自己定义了泛型。 然后将定义的泛型，传递给了父类。 这时候，子类是什么类型，父类就是什么类型

class OldPlayer<E> implements Player<E> {

    @Override
    public E play(E e) {
        return null;
    }
}

