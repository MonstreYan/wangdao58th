package com.cskaoyan._16annotation._03usage;

/**
 * 3.数组形式赋值 {}
 *
 * @author Common-zhou
 * @since 2024-03-26 14:56
 */
// 对于数组的赋值。 hobbyArray = {1, 2, 3, 4, 5}
@MyAnnotation8(hobbyArray = {1, 2, 3, 4, 5})
@MyAnnotation81(names = {"One", "Two", "Three"})
public class Demo8 {

}

// 在注解中，数据类型  基本数据类型、String、Class、注解、枚举、各种形式的数组。
@interface MyAnnotation8 {
    int[] hobbyArray();
}


@interface MyAnnotation81 {
    String[] names();
}
