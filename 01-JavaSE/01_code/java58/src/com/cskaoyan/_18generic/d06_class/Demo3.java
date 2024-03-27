package com.cskaoyan._18generic.d06_class;

import org.junit.Test;

/**
 * // 我们会假定一种不存在的类型来代替这个参数类型，等我们真正使用的时候再传入具体的类型。
 * // int i; 这个i是变量。变量名
 * // T data;  这个T就是标识符。
 * // 使用单个大写字母。比如 E T K V R
 * // E element; T type; K key; V value;
 * <p>
 * // 这是一些规范。如果不按照这个规范，写代码也可以跑，但是出问题的风险比较大。
 * // 切记，不要使用String这种东西作为泛型，极容易认错
 *
 * @author Common-zhou
 * @since 2024-03-27 11:14
 */
public class Demo3 {
    @Test
    public void test1() {
        // 泛型标识符： 建议使用单个大写字母。 不要用其他的。
    }

    @Test
    public void test2() {
        User31<Integer> user31 = new User31<>();
        Integer data1 = user31.data1;
        // 不要用其他的来定义泛型，非常容易混淆。
    }

    @Test
    public void test3() {
        // 注意6: 泛型必须使用引用类型
        // User4<int> user1 = new User4<>(); // 报错: 泛型必须使用引用类型
        // User4<Integer> user2 = new User4<>();

        User3<Integer> user3 = new User3<>();

        // Type argument cannot be of primitive type
        // User3<int> user31 = new User3<int>();

    }
}

class User3<E> {
    String data1;
    E data2;
}


// <String> : 泛型的定义。 定义了一个泛型，名字叫做String
// 泛型标识符就直接写大写字母。。
class User31<String> {
    String data1;

    String data2;
}
