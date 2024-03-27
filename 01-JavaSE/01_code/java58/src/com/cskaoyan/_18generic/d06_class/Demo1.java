package com.cskaoyan._18generic.d06_class;

import org.junit.Test;

/**
 * 泛型类： 就是把泛型定义在类上。
 * class 类名<泛型类型1,泛型类型2,....>{
 * }
 *
 * @author Common-zhou
 * @since 2024-03-27 10:59
 */
public class Demo1 {
    @Test
    public void test1() {
        // 1.泛型的定义语法  class 类名<泛型1, ....>
    }

    @Test
    public void test2() {
        // 2.泛型的使用。
        // JDK7写法
        // 类名<实际的类型> 对象名 = new 类名<>();
        Holder1<String> holder1 = new Holder1<>();
        String data = holder1.data;

        // JDK5的写法
        // 类名<实际的类型> 对象名 = new 类名<实际的类型>();
        Holder1<String> holder11 = new Holder1<String>();
        String data1 = holder11.data;

        // 推荐大家使用。JDK7的写法。，
    }


    @Test
    public void test3() {
        // 3.默认类型。 如果泛型没有写， 这时候全都是默认类型。 默认类型都是Object
        Holder1 holder1 = new Holder1();

        Object data = holder1.data;
    }
}

// T就是泛型。 T不需要存在。
// 定义了泛型之后，就可以在里面使用
class Holder1<T> {
    T data;
}
