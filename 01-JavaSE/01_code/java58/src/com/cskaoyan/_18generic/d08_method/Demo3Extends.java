package com.cskaoyan._18generic.d08_method;

/**
 * 泛型不允许协变， 但是又想产生类似协变的效果。 所以，它整了一些通配符
 * ① 泛型通配符<?>
 * 任意类型，如果没有明确，那么就是Object以及任意的Java类了
 * ② ? extends E
 * 向下限定，E及其子类
 * ③ ? super E
 * 向上限定，E及其父类
 *
 * @author Common-zhou
 * @since 2024-03-28 11:34
 */
public class Demo3Extends {

    public static void main(String[] args) {
        Demo3Extends demo3Extends = new Demo3Extends();


        User2<String> stringUser2 = new User2<>();
        demo3Extends.print(stringUser2);

        User2<Integer> user2 = new User2<>();
        demo3Extends.print(user2);
    }

    // 现在，这个打印方法。我想让它能打印 User2<String>  User<Integer>
    public void print(User2<?> user2) {
        System.out.println(user2.data1);
    }
}

class User2<T> {
    T data1;
}
