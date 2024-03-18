package com.cskaoyan._09string._04api;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Common-zhou
 * @since 2024-03-18 15:58
 */
public class Demo5 {
    @Test
    public void test1() {
        // String类的替换功能
        // 在新的字符串中，用新(new)字符，替换旧(old)字符  "abcd"
        // String replace(char old,char new)
        //
        // 在新的字符串中，用新的字符串(new), 替换旧(old)字符串
        // String replace(String old, String new)
        String s = "abcaaabbbABC";

        String replace = s.replace('a', '0');
        System.out.println(s);
        System.out.println(replace);

        String replace1 = s.replace("abc", "ABC");
        System.out.println(replace1);

    }

    @Test
    public void test2() {
        // 在新的字符串中，去掉开头和结尾的空格字符 "abc"  "abc    " "      abc    " "a   bc"
        // String trim()
        // 只会去掉开头和结尾的。中间的空格，不会被干掉。

        String s1 = "  a  bc  ";
        System.out.println("s1 = \"" + s1 + "\"");
        System.out.println("s1.trim() = \"" + s1.trim() + "\"");



    }

    @Test
    public void test3() {
        // 分隔功能
        // 将字符串按照符号分隔成字符串数组  "a,b,c,d"
        // String[] split(String re)

        String s = "a,b,c,d,e,f";

        String[] split = s.split(",");
        // System.out.println(split);
        System.out.println(Arrays.toString(split));

        String[] split1 = s.split(" ");
        System.out.println(Arrays.toString(split1));

        // 如果想全拆开。    split("")

        String[] split2 = s.split("");
        System.out.println(Arrays.toString(split2));

    }

    @Test
    public void test4() {
        // 1:给出一句英文句子： "i want a bing dun dun"
        // 2:每个单词的首字母都转换为大写并输出

        // I Want A Bing Dun Dun

        String s = "i want a bing dun dun";

        String[] split = s.split(" ");


        // [i  ,want, a, bing, dun, dun  ]
        // bug: 你的心理预期和代码实际运行不一致

        // 首先，先进行分割。分割后，对每个单词进行分别的首字母大写处理。
        for (String string : split) {
            String result = string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();

            System.out.println(result);
        }


    }
}
