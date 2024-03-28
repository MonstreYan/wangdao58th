package com.cskaoyan._18generic.d08_method;

/**
 * 泛型的擦除： Java中的泛型，不是真的泛型，在编译之前有。在编译成class之后，就会变成，Object及类型的强转
 *
 * @author Common-zhou
 * @since 2024-03-28 11:49
 */
public class Demo6Erase {
    public static void main(String[] args) {
        User6<String> stringUser6 = new User6<>();
        stringUser6.data1 = "6data1";
        stringUser6.data2 = "6data2";

        String data2 = stringUser6.data2;

        System.out.println(data2);

    }
}


class User6<T> {
    T data1;
    T data2;
}
