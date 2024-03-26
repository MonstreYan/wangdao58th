package com.cskaoyan._17gc;

/**
 * JVM 为了确定一个对象，是否是垃圾。 设计了很多算法。
 * <p>
 * 1.引用计数算法
 * 如果有引用指向我，+1. 如果它是0，代表它是个垃圾。
 * 确定哪些对象已经变成了垃圾，最简单的算法就是引用计数法
 * 给对象添加一个引用计数器
 * 每当一个地方引用它时，计数器加1
 * 每当引用失效时，计数器减少1
 * 当计数器的数值为0时，也就是对象无法被引用时，表明对象不可在使用
 * <p>
 * 但是这个算法存在一个致命的缺陷，无法解决循环引用的问题
 *
 * @author Common-zhou
 * @since 2024-03-26 16:33
 */
public class Demo2 {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        User user = new User();
        User21 user21 = new User21();

        User22 user22 = new User22();

        user21.user22 = user22;
        user22.user21 = user21;

    }
}

class User21 {
    User22 user22;
}

class User22 {
    User21 user21;


}


