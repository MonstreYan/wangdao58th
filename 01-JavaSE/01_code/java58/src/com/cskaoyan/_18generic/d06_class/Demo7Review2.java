package com.cskaoyan._18generic.d06_class;

import org.junit.Test;

/**
 * 泛型在父子继承关系上的表现。
 *
 * @author Common-zhou
 * @since 2024-03-28 10:05
 */
public class Demo7Review2 {
    @Test
    public void test1() {
        // 泛型是跟着对象一起走的。
        Father1<String> father1 = new Father1<>();
        String ft = father1.ft;

        Father1<Integer> father2 = new Father1<>();
        Integer ft1 = father2.ft;
    }

    @Test
    public void test2() {
        Son11 son11 = new Son11();
        Object ft = son11.ft;


        Son12 son12 = new Son12();
        String ft1 = son12.ft;

        Son13<Double> son13 = new Son13<>();
        Integer ft2 = son13.ft;
    }

    @Test
    public void test3() {
        Son14<String> son14 = new Son14<>();

        String ft = son14.ft;

        Son15<Integer> son15 = new Son15<>();
        Integer ft1 = son15.ft;
    }

    @Test
    public void test4() {
        // 泛型是跟着对象一起走的。
        Father1<Integer> father1 = new Father1<>();
        Integer ft = father1.ft;

        Son14<String> stringSon14 = new Son14<>();
        String ft1 = stringSon14.ft;
    }
}


class Father1<T> {
    T ft;
}

// 继承的时候，子类不指定父类的泛型。 这时候父类里面的是Object类型（默认类型）
class Son11 extends Father1 {
}

// 继承的时候，指定父类的泛型是一个固定的类型。 无论子类指定泛型与否
class Son12 extends Father1<String> {
}

class Son13<E> extends Father1<Integer> {
}


// 继承的时候，父类使用子类的泛型。
// 写了两种情况：是为了给大家验证，跟泛型的符号没有关系，只跟位置有关
// 前面叫做定义，后面叫做使用。 前面定义了，后面才能使用。
class Son14<E> extends Father1<E> {
}


class Son15<T> extends Father1<T> {
}
