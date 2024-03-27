package com.cskaoyan._18generic.d07_interface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型接口，就是把泛型定义在接口上。
 *
 * <p>
 * interface 接口名<泛型类型1, 泛型类型2>{}
 *
 * @author Common-zhou
 * @since 2024-03-27 11:52
 */
public class Demo1 {

    @Test
    public void test1() {
        // 泛型接口，在JDK的代码里，随处可见。

        List<String> list = new ArrayList<>();
    }
}
