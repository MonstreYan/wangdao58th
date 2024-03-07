package com.cskaoyan._04oop1._14import;

import com.cskaoyan._04oop1._14import.another.*;
// 把max这个静态方法导入进来。
import static java.lang.Math.max;

/**
 * @author Common-zhou
 * @since 2024-03-07 17:24
 */
public class Demo2 {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();

        // 静态导入。 可以把一些类里面的静态成员导进来。当做这玩意，在你的代码里面。

        int max = Math.max(1, 2);
        System.out.println(max);

        int max1 = max(1, 2);
        System.out.println(max1);

    }
}
