package com.cskaoyan._19collection._01ds;

import org.junit.Test;

import java.util.Arrays;

/**
 * 数组相关的操作。
 * 练习大致分为这几个方向：
 * 1.插入数据。 比如，往数组的中间位置插入数据。
 * 先将后面的数据往后挪，挪出一个空位。再把想插入的数据插入进去。
 * 2.删除数据。 比如，删除 index=2的数据。比如，删除zs的数据。
 * 3.查找。 查找 jingtian 的下标。
 * 遍历。遍历的时候判断，如果是 jintian，找一个下标存起来。
 * <p>
 * 在线性表里面有遍历。树。图。
 *
 *
 * TODO: 比如，创建6个学生。数组长度是10.
 * 学生有这些数据,id,name,age,score,address
 * Student[] students= new Student[10];
 * 1.先初始化6个学生进去。
 * 2.在 zs 学生的前面，插入一个学生。  jingtian
 * 3.删除 叫ls的学生
 * 4.统计一下，有多少  湖北  的同学。
 * 5.计算一下，班级平均分。
 * 6.计算，班级有多少高于平均分的学生。
 *
 * @author Common-zhou
 * @since 2024-03-28 14:49
 */
public class Demo1Array {

    @Test
    public void test1() {
        // 先准备一个数据： 茶百道、书亦烧仙草、蜜雪冰城、茶颜悦色、喜茶、霸王茶姬
        String[] teaList = new String[]{"茶百道", "书亦烧仙草", "蜜雪冰城", "茶颜悦色", "喜茶", "霸王茶姬"};

        //                       |
        //  0       1            2           3        4       5
        // "茶百道", "书亦烧仙草", "蜜雪冰城", "茶颜悦色", "喜茶", "霸王茶姬"
        // 现在，需要在 index = 2位置，插入一个  七分甜。

        // 因为数组的位置不够。所以插入数据需要新建一个数组，将原本的数据copy过去。

        String[] newTeaList = new String[teaList.length + 1];

        for (int i = 0; i < teaList.length; i++) {
            newTeaList[i] = teaList[i];
        }
        System.out.println(newTeaList);
        System.out.println(Arrays.toString(newTeaList));

        // "茶百道", "书亦烧仙草", "蜜雪冰城", "茶颜悦色", "喜茶", "霸王茶姬"   Null
        //  0       1            2           3        4       5         6

        newTeaList[6] = newTeaList[5];
        newTeaList[5] = newTeaList[4];
        newTeaList[4] = newTeaList[3];
        newTeaList[3] = newTeaList[2];
        System.out.println(Arrays.toString(newTeaList));

        newTeaList[2] = "七分甜";
        System.out.println(Arrays.toString(newTeaList));
    }

    @Test
    public void test2() {
        String[] teaList = new String[10];
        teaList[0] = "茶百道";
        teaList[1] = "书亦烧仙草";
        teaList[2] = "蜜雪冰城";
        teaList[3] = "茶颜悦色";
        teaList[4] = "喜茶";
        teaList[5] = "霸王茶姬";

        int count = 6;
        int index = 2;

        // 代入进去试一下。
        // 假设等于 i=index
        for (int i = count; i > index; i--) {
            teaList[i] = teaList[i - 1];
        }

        // 为什么有bug。 你的预期和代码实际不一样。
        System.out.println(Arrays.toString(teaList));

        // 在index为2位置插入一条数据。 count就是数据的长度。 不允许使用上帝视角。
        // 七分甜

        teaList[index] = "七分甜";

        System.out.println(Arrays.toString(teaList));
    }

    @Test
    public void test3() {
        // index=2 这个也是别人给的。 在真实的案例中，这种东西，都是自己算出来的。
        // 比如，题目告诉你，往蜜雪冰城前面插入数据。
        // 所以第一步，应该是查找蜜雪冰城的下标。

        String[] teaList = new String[10];
        teaList[0] = "茶百道";
        teaList[1] = "书亦烧仙草";
        teaList[2] = "蜜雪冰城";
        teaList[3] = "茶颜悦色";
        teaList[4] = "喜茶";
        teaList[5] = "霸王茶姬";


        // 数组里面遍历方式： foreach、fori
        for (String s : teaList) {
            // 可以遍历，但是拿不到下标。
        }

        int findIndex = -1;

        for (int i = 0; i < teaList.length; i++) {
            String element = teaList[i];
            // 用上面的写法。
            if ("蜜雪冰城".equals(element)) {
                // System.out.println(i);
                findIndex = i;
            }
            // if (element.equals("蜜雪冰城")){}
        }

        // 对象序列化。 把对象，转换为字符串。
        System.out.println(findIndex);

    }


    @Test
    public void testRemove() {
        String[] teaList = new String[10];
        teaList[0] = "茶百道";
        teaList[1] = "书亦烧仙草";
        teaList[2] = "蜜雪冰城";
        teaList[3] = "茶颜悦色";
        teaList[4] = "喜茶";
        teaList[5] = "霸王茶姬";
        System.out.println(Arrays.toString(teaList));

        // 现在，想删除 书亦烧仙草
        teaList[1] = teaList[2];
        System.out.println(Arrays.toString(teaList));
        teaList[2] = teaList[3];
        System.out.println(Arrays.toString(teaList));
        teaList[3] = teaList[4];
        System.out.println(Arrays.toString(teaList));
        teaList[4] = teaList[5];

        System.out.println(Arrays.toString(teaList));
        teaList[5] = null;
        System.out.println(Arrays.toString(teaList));

    }

    @Test
    public void testRemove2() {
        String[] teaList = new String[10];
        teaList[0] = "茶百道";
        teaList[1] = "书亦烧仙草";
        teaList[2] = "蜜雪冰城";
        teaList[3] = "茶颜悦色";
        teaList[4] = "喜茶";
        teaList[5] = "霸王茶姬";

        // 假设，现在要删 蜜雪冰城 。
        int mixueIcecreamIndex = -1;
        for (int i = 0; i < teaList.length; i++) {
            if ("蜜雪冰城".equals(teaList[i])) {
                // System.out.println(i);
                mixueIcecreamIndex = i;
            }
        }
        int count = 6;

        // count = 6
        // i = 2   3 4 5
        for (int i = mixueIcecreamIndex; i < count; i++) {
            teaList[i] = teaList[i + 1];
            // teaList[i + 1] = teaList[i];
        }

        System.out.println(Arrays.toString(teaList));


    }

}
