package com.cskaoyan._18generic.d05;

import com.cskaoyan._18generic.d01.Truck;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 泛型： 参数化类型。类型是不固定的。 你传入什么类型，它就是什么类型。
 * 在工作过程有什么作用。 主要的作用，就是在集合容器中使用。
 *
 * 参数化类型。提供灵活可变的参数化。不能只能装String、
 *
 * @author Common-zhou
 * @since 2024-03-27 10:34
 */
public class Demo1 {
    @Test
    public void test1() {
        // JDK提供了一套类。用来简化操作的。

        // JDK提供了一套类，允许大家伙能存所有东西。
        ArrayList<String> arrayList = new ArrayList<>();

        // String s = arrayList.get(0);
        // arrayList.add();

        // 将问题提前，提前到了编译期。
        // arrayList.add(123456);


        // 泛型在工作中，就是用来存储各种类型。

        // 能不能创建一个类，能存储所有的东西。

        ArrayList<Truck> arrayList2 = new ArrayList<>();

        // Truck truck = arrayList2.get();
        // arrayList2.add()


    }
}
