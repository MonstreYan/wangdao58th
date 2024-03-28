package com.cskaoyan._18generic.d06_class;

import org.junit.Test;

/**
 * 泛型在工作过程中的作用：
 * 因为在集合类中，大量使用了泛型。
 * 因为集合类，是装数据的（数组）。  也希望集合类，能装卡车、小汽车、摩托车、自行车。
 * <p>
 * 车库
 * <p>
 * 就是因为集合类，需要存储各种数据类型，而且不希望做强制类型转换，这时候里面大量使用泛型。
 *
 * @author Common-zhou
 * @since 2024-03-28 09:36
 */
public class Demo6Review {

    public static void main(String[] args) {
        // List
        // ArrayList
        // LinkedList
        // Map
    }

    @Test
    public void test1() {
        // 1.泛型的写法。
        User6<String> stringUser6 = new User6<String>();

        // ==========推荐使用这种写法。
        User6<String> stringUser61 = new User6<>();

        // 错误写法: 前面不写泛型，后面写泛型。
        User6 user6 = new User6<String>();
        // user6.data1
    }

    @Test
    public void test2() {
        User61 user61 = new User61();

        // 2.写了泛型，但是使用的时候，不传。是默认类型， Object。

        // 3.写了多个泛型，使用的时候，要么都传，要么都不传。
        // Wrong number of type arguments: 1; required: 2
        User61<String, Integer> user611 = new User61<>();

        // data1 什么类型： String
        // 按顺序传递，然后在大括号里面，按照类型使用。 (T是String； E是Integer。)
        // User61<String, Integer>
        // class User61<T, E>
    }

    @Test
    public void test3() {
        // 4.在定义泛型标识符的时候。一定要用单个大写字母。
        // =================================================================
        // E T  K  V  R  P  L W

        // 它不是语法限制。
        // 防御性编程：防御性（防着自己被裁。）
        User62<Double, Float, Integer> user62 = new User62<>();
        // user62.data1

        // 自己写代码  ===》  leader
    }

    @Test
    public void test4() {
        // 5.泛型类型，一定要使用引用数据类型。
        User6<Integer> user6 = new User6<>();
        // User6<int> user61 = new User6<>();
    }

}


// 泛型类，怎么定义的？泛型定义在类上
// 1.泛型的写法。
class User6<T> {
    T data1;
}

class User61<T, E> {
    T data1;
    T data2;
    E data3;
}


class User62<String, Integer, System> {
    String data1;

    // 全限定类名
    java.lang.String data2;

    Integer i1;
    java.lang.Integer i2;
}
