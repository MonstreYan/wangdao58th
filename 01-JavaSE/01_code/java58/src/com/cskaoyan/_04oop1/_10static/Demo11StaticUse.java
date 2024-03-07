package com.cskaoyan._04oop1._10static;

import java.util.Arrays;

/**
 * static在哪些地方可以使用。
 * <p>
 * 假设，这是腾讯的QQ号生成类。  现在，它需要存储自己生成到多少了。 这里
 * static
 *
 * 这个需要掌握。==================
 * 1.静态成员变量： 其实在工作过程中，静态成员变量使用的不是特别多。 一般就是全局需要共享数据的时候，可能会用。
 * 2.静态成员方法： 当做工具类里面的工具方法。就是不需要创建对象，可以直接调用这个方法。
 *
 * @author Common-zhou
 * @since 2024-03-07 14:30
 */
public class Demo11StaticUse {
    public static void main(String[] args) {

        // 这是什么写法？   类名.方法
        int[] nums = new int[]{1, 23};

        // 怎么往一个方法里面跳： ctrl键点住
        String string = Arrays.toString(nums);

        // Arrays 就是一个工具类。
        // Collections.fill();

    }
}

class QQObject {
    // 这个是一个QQ号。
    public String qqId;

    // 我们当前，生成了多少个QQ号。 也要存
    // 一定需要用static来存储。
    // 变量的名字非常重要。
    public static int currentQQGenerateCount = 10001;
    // public static int i = 10001;

    // 代码有时候能写出来，但是出了问题，不好调
    // 1.逻辑没有捋清楚。    ===》  使用注释将自己的思路写出来。
    // 2.命名要准确，切合代码的实际功能    ==> 命名其实就是在说明程序的功能。

    // 写代码之前，先写注释。 再根据注释写代码，其实是推荐的方式。
}

