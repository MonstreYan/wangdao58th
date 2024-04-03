package com.cskaoyan._20map._04homework;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组 words 和一个字符串 chars. 如果一个字符串能被 chars 里面的字符组成，
 * 那么这个字符串就是"好"的(chars里面每个字符只能使用一次)。
 * 求：words 里面所有好的字符串的字符总个数。
 * <p>
 * 比如：
 * words = ["cat", "bt", "hat", "tree"]
 * chars = "atach"
 * 好的字符串有 "cat", "hat", 3 + 3 = 6.
 * 输出：6
 *
 * @author Common-zhou
 * @since 2024-04-03 09:32
 */
public class Homework1 {
    public static void main(String[] args) {
        // 不要把简单的问题。复杂了。
    }

    @Test
    public void test1UseList() {
        String[] words = {"caaat", "bt", "hat", "tree"};
        String chars = "atach";

        // "cat", "bt", "hat", "tree"
        for (String word : words) {
            // word现在，拿到是一个一个怎样的数据。
            // 这个方法的作用，就是判断这个字符，是否是一个好字符。
            if (isGoodString(word, chars)) {
                System.out.println(word);
            }
        }
    }

    /**
     * 判断一个字符是否是好的。
     * List的时间复杂度太高了。
     *
     * @param word  n
     * @param chars m
     * @return m  + n *  (m)
     * atach   m     [a t  a  c h ]
     * cat  n{m}
     * 使用List来接，解法非常的简单易懂。 但是时间复杂度太高。
     */
    private boolean isGoodString(String word, String chars) {

        // word: cat     bt      hat   tree
        // chars : atach
        List<Character> characterList = new ArrayList<>();

        // atach   chars.length()=5
        // 0   1   2  3   4
        for (int i = 0; i < chars.length(); i++) {
            char charAt = chars.charAt(i);
            characterList.add(charAt);
        }
        // a  t   a  c  h
        // System.out.println(characterList);

        // cat 0 1 2
        // 判断List里面，是否包含 word里面的所有字符。  先判断包不包含，如果不包含，说明就是坏的；
        for (int i = 0; i < word.length(); i++) {
            char charAt = word.charAt(i);
            boolean contains = characterList.contains(charAt);

            if (!contains) {
                return false;
            }
            characterList.remove((Character) charAt);
        }

        return true;
    }


    @Test
    public void test1UseMap() {
        String[] words = {"caat", "bt", "hat", "tree"};
        String chars = "atach";
        int count = 0;

        for (String word : words) {
            if (isGoodStringUseMap(word, chars)) {
                // System.out.println(word);
                count += word.length();
            }
        }
    }

    private boolean isGoodStringUseMap(String word, String chars) {

        // word = cat
        // chars = atach

        // 用Map来完成。
        // 现在，需要判断 chars里面的字符，能否组成word里面的全部。
        // Map应该怎样设置自己的key， 自己的value。

        // key是字符， value是个数。
        // 思路1： 使用两个map。第一个map装word的字符和个数； 第二个map装 chars的字符和个数。
        // 遍历 todo 下午自己写一下。
        // {c=1, a=1, t=1,b=1}
        // [a=2, c=1, t=1, h=1]

        // 思路2： 一个map。 存chars；  遍历word， 如果里面有，map对应的key的value-； 如果没有或者小于， 不是个好的
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0; i < chars.length(); i++) {
            char charAt = chars.charAt(i);
            Integer count = charCountMap.getOrDefault(charAt, 0);
            charCountMap.put(charAt, count + 1);
        }
        // {a=2, c=0, t=1,h=1}
        // c  c  c  a  t b
        //       |
        for (int i = 0; i < word.length(); i++) {
            char charAt = word.charAt(i);
            Integer count = charCountMap.get(charAt);

            //找到了； 找不到
            if (count == null || count <= 0) {
                return false;
            }
            charCountMap.put(charAt, count - 1);
        }

        return true;
    }


}
