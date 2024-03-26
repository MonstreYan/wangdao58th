package com.cskaoyan._17gc;

/**
 * GC Roots  : 跟搜索算法。 从JVM指定的一系列的跟出发，开始标记。哪些是有用的。 有用就不会被回收掉。没用的
 * 下一次GC的时候，就会被当做垃圾干掉。
 * <p>
 * 有哪些被当做GC  Roots 。
 *
 * 问题操作很复杂。 而且需要 stop the world.
 *
 * @author Common-zhou
 * @since 2024-03-26 16:44
 */
public class Demo3 {

    public static void main(String[] args) {
        User3 user3 = new User3();

        test1();

        for (int i = 0; i < 1000000000; i++) {
            User3 user31 = new User3();
        }

        // System.gc();
    }

    private static void test1() {
        User3 user3 = new User3();
        User22 user22 = new User22();
        User21 user21 = new User21();
        user22.user21 = user21;
        user21.user22 = user22;
    }


}


class User3 {
    private static User22 user22;
    private User22 user23 = new User22();

    static {
        user22 = new User22();
        user22.user21 = new User21();
    }
}
