package com.cskaoyan._08othercls._01wrapper;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-15 17:43
 */
public class Demo7 {
    @Test
    public void testCompareDouble() {
        // Double是没有缓存在的。 所以比较的时候。  一定要用equals

        Double double1 = 2.0;
        Double double2 = 2.0;
        Double double3 = Double.valueOf(2.0);

        System.out.println(double1 == double2);
    }

    @Test
    public void testCompareBoolean() {
        Boolean b1 = true;
        Boolean b2 = true;
        Boolean b3 = Boolean.valueOf(true);

        System.out.println(b1 == b2);
    }

    @Test
    public void test4() {
        // 一定要注意。今后只要是引用数据类型。 比较的时候，一定要用equals进行比较
        // 即使这个东西是包装类。 不要这样做。
    }
}
