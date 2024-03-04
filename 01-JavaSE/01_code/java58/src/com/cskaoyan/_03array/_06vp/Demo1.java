package com.cskaoyan._03array._06vp;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-04 15:53
 */
public class Demo1 {
    @Test
    public void test1() {
        // 可变长参数： 就是一些参数的长度不确定。 这时候Java会把这个东西当做数组来进行处理。

        // [修饰符列表] 返回值类型 方法名 (形式参数列表,数据类型... 变量名){
        // 	//方法体
        // }
        testMethod(1);
        testMethod(1, 2);
        testMethod(1, 2, 3);

        // 数据类型... 变量名  代表允许接收变长的参数列表。 比如长为1 可以， 长为2，长为n都可以。

    }

    public void testMethod(int... i) {
    }

    // public void testMethod(int i) {
    // }

    // 这种，一般有时候用来求和。  你现在想求一堆数据的和。 但是你不确定数据有几个。   可以用可变长参数

    public int sumMethod(int... arr) {
        // arr.length;
        // int i = arr[0];
        // 最终，JVM会把它变成一个数组。 只要塞进来的数据，全部都会放到这个 数组中。

        int sum = 0;
        for (int element : arr) {
            sum += element;
        }
        return sum;

    }
}
