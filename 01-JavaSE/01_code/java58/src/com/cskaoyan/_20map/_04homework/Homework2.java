package com.cskaoyan._20map._04homework;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个字符串 paragraph 和一个表示禁用词的字符串数组 banned ，返回出现频率最高的非禁用词。题目数据 保证
 * 至少存在一个非禁用词，且答案 唯一 。
 * <p>
 * paragraph 中的单词 不区分大小写 ，答案应以 小写 形式返回。
 * <p>
 * 示例 1：
 * 输入：paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
 * 输出："ball"
 * 解释：
 * "hit" 出现了 3 次，但它是禁用词。
 * "ball" 出现了两次（没有其他单词出现这么多次），因此它是段落中出现频率最高的非禁用词。
 * 请注意，段落中的单词不区分大小写，
 * 标点符号会被忽略（即使它们紧挨着单词，如 "ball,"），
 * 并且尽管 "hit" 出现的次数更多，但它不能作为答案，因为它是禁用词。
 * 示例 2：
 * <p>
 * 输入：paragraph = "a.", banned = []
 * 输出："a"
 * <p>
 * ball  Ball BALL
 *
 * @author Common-zhou
 * @since 2024-04-05 09:31
 */
public class Homework2 {

    @Test
    public void test1() {
        String paragraph = "Bob hit a ！ @ #￥%……&&**（（））— ball, the hit BALL flew far after it " + "was hit.";
        String[] banned = {"hit"};

        // 代码会越来越复杂。 现在怎么写代码？
        // 首先先写注释，将关键捋一遍。

        // paragraph.replace(",", " ");
        // String[] split = paragraph.split();

        //  String paragraph = Bob hit a ball  the hit BALL flew far after it was hit
        // 1.将 ,  .  替换成空格。 单词。 split(" "). 拿到字符串数组。
        // 遍历每个字母，不是字母。 将其换成空格； 正则。

        // String paragraph = bob hit a ball  the hit ball flew far after it was hit
        // 2.把字符串拆成一个一个的

        // 3.定义一个Map。 banned放进去。  key是词，value是 Object
        // 4.定义一个Map。 装paragraph里面的单词出现频率。 key是单词， value是次数。

        // 4. 遍历数组中的字符串，然后将字符串转小写。
        //      4.1 如果不是banned。 就放到map中，
        // 5.遍历Map。 找到最大的次数。
    }

    @Test
    public void test2() {
        String paragraph = "Bob hit a ！ @ #￥%……&&**（（））— ball, the hit BALL flew far after it " + "was hit.";

        // "hit"  "bob" "call"
        String[] banned = {"hit"};
        // list.contains("bob") == O(n)
        // map.containsKey() == O(1)

        // 代码会越来越复杂。 现在怎么写代码？
        // 首先先写注释，将关键捋一遍。

        // paragraph.replace(",", " ");
        // String[] split = paragraph.split();

        //  String paragraph = Bob hit a ball  the hit BALL flew far after it was hit
        // 1.将 ,  .  替换成空格。 单词。 split(" "). 拿到字符串数组。
        // 遍历每个字母，不是字母。 将其换成空格； 正则。
        // ("[^a-zA-Z]", " ")
        String paragraphNoOtherCharacter = paragraph.replaceAll("[^a-zA-Z]", " ");
        String lowerCaseParagraph = paragraphNoOtherCharacter.toLowerCase();

        System.out.println(lowerCaseParagraph);


        // String paragraph = bob hit a ball  the hit ball flew far after it was hit
        // 2.把字符串拆成一个一个的
        String[] splitParagraph = lowerCaseParagraph.split(" ");

        // 3.定义一个Map。 banned放进去。  key是词，value是 Object
        Map<String, Object> bannedMap = new HashMap<>();
        for (String bannedLetter : banned) {
            bannedMap.put(bannedLetter, "");
        }

        // 4.定义一个Map。 装paragraph里面的单词出现频率。 key是单词， value是次数。
        Map<String, Integer> paragraphCountMap = new HashMap<>();

        // 4. 遍历数组中的字符串，
        for (String letter : splitParagraph) {

            if (letter == null || letter.length() == 0) {
                continue;
            }

            // 4.1 如果不是banned。 就放到map中，
            Integer count = paragraphCountMap.getOrDefault(letter, 0);

            paragraphCountMap.put(letter, count + 1);
        }
        //
        // 5.遍历Map。 找到最大的次数。
        int maxOccurrenceCount = 0;
        String maxOccurrenceLetterNotBanned = "";

        Set<Map.Entry<String, Integer>> entries = paragraphCountMap.entrySet();

        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer count = entry.getValue();
            if (bannedMap.containsKey(key)) {
                continue;
            }

            if (count > maxOccurrenceCount) {
                maxOccurrenceCount = count;
                maxOccurrenceLetterNotBanned = key;
            }
        }

        System.out.println("maxOccurrenceCount = " + maxOccurrenceCount);
        System.out.println("maxOccurrenceLetterNotBanned = --" + maxOccurrenceLetterNotBanned +
                "--");
        // paragraphCountMap.keySet()


    }

}
