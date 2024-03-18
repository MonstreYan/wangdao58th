package com.cskaoyan._09string._04api;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-18 14:38
 */
public class Demo2 {
    @Test
    public void test1() {
        // 获取当前字符串对象中，包含的字符个数 "abcd"
        // int length()
        String s = "景天老师又喝茶颜悦色";

        System.out.println("s.length() = " + s.length());
        // 和数组里面。

        // int[] nums = new int[10];
        // nums.length
    }


    @Test
    public void test2() {
        // 获取字符串对象代表字符序列中，指定位置的字符 从0开始"abcd"
        // char charAt(int index)

        // 景天老师喜欢给大家分享好喝的奶茶
        // 0 1 2
        String s = "景天老师喜欢给大家分享好喝的奶茶";
        char charAt = s.charAt(0);
        System.out.println("charAt = " + charAt);

        char charAt1 = s.charAt(4);
        System.out.println("charAt1 = " + charAt1);


    }


    @Test
    public void test4() {
        // 在当前字符串对象中查找指定的字符，如果找到就返回字符，首次出现的位置，如果没找到返回-1
        // 也可以填字符   "abcdb"
        // int indexOf(int ch)

        // 中文在里面，是怎么存储的？
        String s = "景天老师喜欢给大家分享好喝的奶茶";

        int index = s.indexOf(26224);
        System.out.println(index);

        // char c = '景';
        // System.out.println(c + 0);

        char c = 26224;
        System.out.println(c);


    }


    @Test
    public void test5() {
        String s = "abcedfaaabbbc";
        // 在当前字符串对象中查找指定的字符，如果找到就返回字符首次出现的位置，如果没找到返回-1
        // 也可以填字符   "abcdb"
        // int indexOf(int ch)

        int index = s.indexOf(97);
        System.out.println(index);

        System.out.println("s.indexOf(98) = " + s.indexOf(98));

        // 指定从当前字符串对象的指定位置开始，查找首次出现的指定字符的位置，(如果没找到返回-1)
        // 可以填入字符
        // int indexOf(int ch,int fromIndex)

        // abcedfaaabbbc
        int index2 = s.indexOf(97, 3);
        System.out.println("index2 = " + index2);

        // 查找当前字符串中，目标字符串首次出现的位置(如果包含)，找不到，返回-1
        // 这里的位置是指目标字符串的第一个字符,在当前字符串对象中的位置  "abcdefg"
        // int indexOf(String str)
        // 指定，从当前字符串对象的指定位置开始,查找首次出现的指定字符串的位置(如果没找到返回-1)
        // 这里的位置是指目标字符串的第一个字符,在当前字符串对象中的位置
        // int indexOf(String str,int fromIndex)

        System.out.println("s.indexOf(\"aa\") = " + s.indexOf("aa"));

    }

    @Test
    public void test3() {
        // 返回字符串，该字符串只包含当前字符串中，从指定位置开始(包含指定位置字符)到结束的那部分字符串  "abcdef"
        // String substring(int start)
        //
        // 返回字符串，只包含当前字符串中，从start位置开始(包含)，到end(不包含)指定的位置的字符串  [ , )
        // String substring(int start,int end)

        String s = "hello world";
        String substring = s.substring(1);
        System.out.println(substring);

        String substring1 = s.substring(2, 8);
        System.out.println(substring1);

        // 截取字符串的一部分。


    }

    @Test
    public void test6() {
        // 中国的全称是中华人民共和国
        // The full name of China is the People's Republic of China.

        String s = "China is the People's Republic of China.";

        int index = s.indexOf("China");
        System.out.println(index);
        int index1 = s.indexOf("China", 7);
        System.out.println(index1);

        // 查找指定字符， 找到了就返回首个字符下标，找不到就返回-1

        int index2 = s.indexOf("china", 7);
        System.out.println(index2);

    }


}
