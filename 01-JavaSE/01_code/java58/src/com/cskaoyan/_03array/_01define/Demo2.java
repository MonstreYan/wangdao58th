package com.cskaoyan._03array._01define;

/**
 * 静态初始化
 * <p>
 * 数组在声明之后，仍然不能使用。 因为现在还没有对数组里面的东西进行初始化， 我们需要初始化之后，才能使用
 * <p>
 * 初始化，有两种方式。
 * 第一种是静态初始化。 即，直接告诉JVM，这里面有哪些数据。
 * 数据类型[] 数组名 = new 数据类型[]{元素1, 元素2, 元素3, .....}
 *
 * @author Common-zhou
 * @since 2024-03-02 10:17
 */
public class Demo2 {
    public static void main(String[] args) {

        // 声明了一个数组，数组是存放int类型的。 但是现在还没有初始化
        // int[] nums;

        // Variable 'nums' might not have been initialized
        // System.out.println(nums);

        // 数据类型[] 数组名 = new 数据类型[]{元素1, 元素2, 元素3, .....}
        int[] nums = new int[]{1, 2, 3, 4};

        // 静态初始化有简写形式。
        // 数据类型[] 数组名 = {元素1,元素2,元素3...};
        int[] nums2 = {88, 89, 90};

        //  注：简化的形式必须跟在声明之后，不能单独使用！ 下列写法就是错误的：
        int[] nums3;
        // nums3 = {89, 90, 91};

    }
}
