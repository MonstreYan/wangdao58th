package com.cskaoyan._09string._04api;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-18 14:58
 */
public class Demo3 {

    @Test
    public void test1() {
        // 1. 统计"abc"在字符中"abcdabcfgh"出现的次数
        String s = "abcdabcfghabcaaaabc";

        // 怎么查 abc 在字符串中出现的次数。
        // indexOf(String)   indexOf(String , fromIndex)
        int index = 0;
        int count = 0;

        while (true) {
            index = s.indexOf("abc", index);

            if (index != -1) {
                index++;
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);
    }

    @Test
    public void test2() {
        // 现在，要学会写代码。
        // 比如，用你的十八般武艺，完成需求。

        // 时间过不去。时间复杂度有点高。
        // 现阶段，先把需求做出来。 时间复杂度。
        // O(1)
        // O(n)
        // O(n^2)
        // O(n^3)
        // 只要避免一件事。 不要循环套循环。
    }

    @Test
    public void test3() {
        // 1：遍历获取字符串中的每一个字符
        // "abc001DEF"

        String s = "abc001DEF";
        // 遍历： 访问并且只访问一次。
        // 数组的遍历  [0,1,8,6,8,9,4]

        int length = s.length();
        for (int index = 0; index < length; index++) {
            char charAt = s.charAt(index);
            System.out.println(charAt);
        }

    }

    @Test
    public void test4() {
        // 2：统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数。(不考虑其他字符)
        String s = "abc001DEFabc8";


        // 遍历。得到一个一个的字符
        // 判断是大写字符串、小写字符、数字。
        // a 97 z
        // A  Z   0  9

        int lowerCount = 0;
        int upperCount = 0;
        int digitCount = 0;

        for (int index = 0; index < s.length(); index++) {
            char charAt = s.charAt(index);

            if (charAt >= 'a' && charAt <= 'z') {
                lowerCount++;
            } else if (charAt >= 'A' && charAt <= 'Z') {
                upperCount++;
            } else if (charAt >= '0' && charAt <= '9') {
                digitCount++;
            }
        }


        // 小写有多少。
        System.out.println("lowerCount = " + lowerCount);
        System.out.println("upperCount = " + upperCount);
        System.out.println("digitCount = " + digitCount);

        // 现在一定要多谢代码，而且需要注意变量名，方法名的问题。
        // 变量名如果取得好，可以帮助找bug。
    }
}
