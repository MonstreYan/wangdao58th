package com.cskaoyan._18generic.d06_class;

/**
 * 注意7:  泛型类, 定义了泛型之后, 泛型的作用域
 * - 泛型类定义泛型的作用域:  在自己的类上，或者类中。
 *
 * @author Common-zhou
 * @since 2024-03-27 11:21
 */
public class Demo4 {

}

// class User4<T> extends User3<T>
// 哪个是定义。哪个是使用。
// 前面是定义，后面只是使用前面定义的这个泛型。
class User4<T> extends User3<T> {
    T data1;

    class User4Inner {
        T data2;
    }

}
