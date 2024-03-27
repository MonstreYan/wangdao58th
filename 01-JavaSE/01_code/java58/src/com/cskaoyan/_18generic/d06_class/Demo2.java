package com.cskaoyan._18generic.d06_class;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-27 11:07
 */
public class Demo2 {
    @Test
    public void test1() {
        // 3.可以定义多个泛型。
        // 但是不建议定义太多，2个差不多了。 这个限制不是语法层面的限制，只是写代码层面的限制。
    }

    @Test
    public void test2() {
        // 4.定义了多个泛型， 指定泛型的时候，要么全部指定，要么全部不指定。

        User2<String, Integer> user2 = new User2<>();

        String data11 = user2.data1;
        Integer data2 = user2.data2;

        // User2<String> user21 = new User2();

        User2 user21 = new User2();
        Object data1 = user21.data1;

    }
}

class User2<T, E> {
    T data1;
    E data2;
}


class User21<T, E> {
}
