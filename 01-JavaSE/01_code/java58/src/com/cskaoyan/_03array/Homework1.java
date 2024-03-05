package com.cskaoyan._03array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 今天上课的代码敲一遍
 * 1.晚上一定要敲一遍白天的代码。  复习一下， 再去敲作业。
 * 2.作业的目的是让大家复习。
 * 3.敲代码的时候。 不要照着敲。
 * 首先，去理解一下，代码在干什么事情。 然后自己去自己的工程里面，回忆并且敲代码。
 * copy
 * <p>
 * 数组综合练习——真正删除元素
 * 对于某个String类型数组（数组中不考虑存在null元素），将其中的某个元素全部去掉，得到一个新数组，并统计去掉了几个元素。
 * 举例，对于String数组["abc", "123", "123", "123", "666", "777"] 将其中的元素"123"全部去掉，就得到了新数组["abc","666", "777"]，一共去掉了3个元素。
 * 注：
 * 这里说的去掉，不是指用0/null等默认值替代原先的元素，而是指真正的删除掉。
 * 思考：同一个数组能不能实现这个功能？如果不能，应该怎么完成呢？
 * String如何判断内容相同?
 * 该题有一定难度，建议不行放最后做。
 *
 * @author Common-zhou
 * @since 2024-03-05 09:31
 */
public class Homework1 {

    @Test
    public void test1() {
        // 就是将一个数组中的指定值去掉。然后统计去掉了个数。（几个元素）
        String[] originArray = new String[]{"abc", "123", "123", "123", "666", "777"};
        // 现在，要去掉 123。 最终统计去除个数。

        // 版本1： 先做假删除
        for (int i = 0; i < originArray.length; i++) {
            if (originArray[i].equals("123")) {
                // 说明是 123.  ==》 删除。  先做假删除
                originArray[i] = null;
            }
        }
        System.out.println(Arrays.toString(originArray));

        // gui
        // 增删改查
    }


    @Test
    public void testEquals() {
        // equals方法的一个坑。
        // 一定要注意： 不要写出空指针
        // String[] originArray = new String[]{"abc", "123", "123", "123", "666", "777"};
        String[] originArray = new String[]{"abc", null, "123", "123", "666", "777"};
        // 想统计  123  有多少个。

        int i = 0;

        for (String element : originArray) {
            // ==================================
            // 推荐大家使用第二种写法。因为第一种写法。  element可能为null。
            // 在调用equals的时候，一定要确保前面的数据，不为null。
            // 怎么确保： 1）用常量在前面  "123".equals(element)
            // 2) 判断一下。  element != null && element.equals(test1).
            // 为什么这个写法， 会确保它不出空指针？   ==》
            if (element.equals("123")) {
                i++;
                // if ("123".equals(element)) {
            }
        }

        System.out.println("i = " + i);
    }


    @Test
    public void testName() {

        String[] originArray = new String[]{"abc", "123", "123", "123", "666", "777"};

        // 命名的问题： 见名知意。
        // i j k
        // a b c
        // 一个原则： 怎么方便怎么来。 想起啥字母用啥字母。
        // 一定要避免这种写法。 因为在企业里面的一行代码，可能写一次， 但是会被读无数次。
        // 我们可以用命名去解释代码的时候。不要放弃这种选项。
        int count123 = 0;
        // i

        for (String element : originArray) {

            if (element.equals("123")) {
                count123++;
                // if ("123".equals(element)) {
            }
        }

        System.out.println("count123 = " + count123);

        // 驼峰： 多个单词，单词和单词之间，首字母大写的方式来做区分。
        // 类名： 大驼峰。第第一个单词的首字母大写。  StudentInfo  UserServiceImpl
        // 后续一定要注意。 如果被发现，类名还是小驼峰。  test   .跑步2km。
        // 方法名，变量名： 小驼峰。

    }


    @Test
    public void test2() {
        // 就是将一个数组中的指定值去掉。然后统计去掉了个数。（几个元素）
        String[] originArray = new String[]{"abc", "123", "123", "123", "666", "777", "zhangsan", "987654"};
        // 现在，要去掉 123。 最终统计去除个数。

        // 版本2： 做真删除
        int remainingNumber = 0;
        // 步骤1：先统计一下， 除了  123 之外， 有多少数据。 有多少个
        for (String element : originArray) {
            // if (element.equals("123"))
            if (!"123".equals(element)) {
                // 找到 不是 123
                remainingNumber++;
            }
        }

        // 重新创建数组， 数组长度多少？
        // String[] newArray = new String[]{"abc", "666", "777"};
        String[] newArray = new String[remainingNumber];
        // int i = 0;
        int currentIndex = 0;

        for (String element : originArray) {
            if (!"123".equals(element)) {
                // 复制。
                newArray[currentIndex] = element;
                currentIndex++;
            }
        }

        System.out.println(Arrays.toString(newArray));


        // 对于这种真正的删除。 其实就是将数据个数统计一下。 然后创建新的数组。
        // 然后把原数组的数据copy过去。

        // 能否在原始的数组上完成这个功能。
        // 可以。但是需要记录两个事情。 现在装数据的长度。
        // 需要有一个空 来表示它。  null
        // ArrayList  ==> 底层就是数组。 这个就是JDK为我们提供的集合类。
    }


    @Test
    public void test4() {
        ArrayList objects = new ArrayList<>();

        objects.add("zs");
        objects.add("ls");
        objects.add("wu");
        objects.add("zl");
        objects.add("jingtian");
        System.out.println(objects);

        objects.remove("zs");
        System.out.println(objects);

        // ArrayList就非常类似于数组。     new String[]{"zs", "ls", "wu", "zl"}
        // 数组的操作，非常不便利。   假设要添加   jingtian

        // 现在，大家可以先用。 ArrayList
    }

    @Test
    public void test5(){
        // new ArrayList<>();
        // 如果你想用 ArrayList存储  String. 这样写。

        // <> 里面代表装的类型。
        ArrayList<String> strings = new ArrayList<>();
        // 在这里面，先不要存储基本数据类型。
        // "1"

        // 在idea里面。点一下， 然后看方法名。
        // strings.toArray()

    }

}
