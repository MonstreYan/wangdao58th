package com.cskaoyan._03array._05operations;

import org.junit.Test;

/**
 * 获取数组中的极值。
 * 最大值， 最小值。
 * <p>
 * 有一个数组， 代表我们班的语文成绩。 想获取最高的语文分数； 最低的语文分数。
 *
 * @author Common-zhou
 * @since 2024-03-04 14:54
 */
public class Demo4 {

    @Test
    public void testFindMax() {
        int[] scores = {60, 90, 95, 92, 98, 55};

        // 打擂台的方式。
        int maxScore = scores[0];

        for (int i = 1; i < scores.length; i++) {
            // 如果上来的分数。 比最高分大，说明，当前分是到目前位置的最高分。 这时候，替换。
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }

        System.out.println("maxScore = " + maxScore);
    }

    @Test
    public void testFindMin() {
        int[] scores = {60, 90, 95, 92, 98, 55};

        // 打擂台的方式。
        // shift + f6 可以整体替换变量名。
        int minScore = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < minScore) {
                minScore = scores[i];
            }
        }

        System.out.println("minScore = " + minScore);
    }


    @Test
    public void testFindAvg() {
        // 平均值。 怎么求？
        int[] scores = {60, 90, 95, 92, 98, 55};

        int totalScoreSum = 0;

        for (int score : scores) {
            totalScoreSum += score;
        }

        // 为什么要乘1.0  要让它变成一个double。
        // 在Java中。 int / int  得到的是int。 平均分可能是小数。
        double avgScore = 1.0 * totalScoreSum / scores.length;
    }

    @Test
    public void test4(){
        // 最值是否可以用排序
        // 可以排序。 但是效率太差。

        // 10万条。

        // 如果直接找最大值：
        // 时间复杂度？  O(n)

        // 如果排序：  O(nlog(n))

        // 10亿。
    }
}
