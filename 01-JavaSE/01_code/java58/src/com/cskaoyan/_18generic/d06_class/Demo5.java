package com.cskaoyan._18generic.d06_class;

import org.junit.Test;

/**
 * 泛型在父子继承关系上的表现
 *
 * @author Common-zhou
 * @since 2024-03-27 11:25
 */
public class Demo5 {

    @Test
    public void test1() {
        // 目前是一个普通的泛型。 泛型在父子继承关系怎么表现。
        Father<String> father = new Father<>();
        String ft = father.ft;
    }


    @Test
    public void test2() {
        Son1 son1 = new Son1();
        // 继承的时候，子类没有泛型，也没有给父类指定泛型。这时候泛型的类型就是Object。
        Object ft = son1.ft;
    }

    @Test
    public void test3() {
        Son2 son2 = new Son2();
        String ft = son2.ft;
    }

    @Test
    public void test4() {
        Son3<String> stringSon3 = new Son3<>();
        Integer ft = stringSon3.ft;
        String ft2 = stringSon3.ft2;
    }

    @Test
    public void test5() {
        Son3 stringSon3 = new Son3();
        Object ft2 = stringSon3.ft2;
        // 泛型其实也是强转。 你不写泛型，
        Object ft = stringSon3.ft;
        // 当做特殊案例了解一下。
    }

    @Test
    public void test6() {
        Son4<String> son4 = new Son4<>();
        String ft = son4.ft;

        Son4<Integer> son41 = new Son4<>();
        Integer ft1 = son41.ft;
    }

    @Test
    public void test7() {
        Son5<String> stringSon5 = new Son5<>();
        String ft = stringSon5.ft;

        Son5<Integer> son5 = new Son5<>();
        Integer ft1 = son5.ft;
    }

    @Test
    public void test8() {
        Son6<Integer> integerSon6 = new Son6<>();

        Integer ft = integerSon6.ft;
        // 泛型标识符，使用单个大写字母。 不要给自己挖坑。
    }
}

class Father<T> {
    T ft;
}

// 继承的时候，没有指定泛型。也没有给父类指定了泛型， 这时候，泛型是默认类型，Object
class Son1 extends Father {
}

// 继承的时候，没有指定泛型。给父类指定了泛型， 这时候父类就是指定的类型。
class Son2 extends Father<String> {
}

// 子类有泛型。 给父类指定了泛型类型。 但是两个不是同一个
class Son3<T> extends Father<Integer> {
    T ft2;
}

// 子类有泛型。而且父类使用这个泛型
// class Son4<T> extends Father<T>
// 前面的T是定义； 后面的T是使用
class Son4<T> extends Father<T> {
}

// 跟泛型的符号没有关系。 只跟传递有关。
class Son5<E> extends Father<E> {
}


class Son6<String> extends Father<String> {
}
