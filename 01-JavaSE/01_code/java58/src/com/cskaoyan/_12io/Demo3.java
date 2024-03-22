package com.cskaoyan._12io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 有这样的一个words数组，数组中每个字符串的格式为“词性:单词”
 * String[] words = {"verb:eat","verb:drink","verb:sleep",
 * "verb:play","noun:rice","noun:meat","noun:hand","noun:hair"};
 * <p>
 * 根据单词性质动词verb全部存入verb.txt文件中
 * 根据单词性质名词noun全部存入noun.txt文件中
 * <p>
 * 在外围准备两个输出流。
 * 1.遍历数组。 verb:eat   split(":")   startWith
 *
 *
 * 在很多题目里面，基本都是遍历。 用字符串的相关API完成功能。
 *
 * @author Common-zhou
 * @since 2024-03-22 10:17
 */
public class Demo3 {

    public static void main(String[] args) throws IOException {
        String[] words = {"verb:eat", "verb:drink", "verb:sleep", "verb:play", "noun:rice", "noun:meat", "noun:hand", "noun:hair"};

        FileOutputStream verbOutputStream = new FileOutputStream("verb.txt");
        FileOutputStream nounOutputStream = new FileOutputStream("noun.txt");

        // 1.遍历数组。 得到一个一个的字符串
        for (String word : words) {
            // verb:eat

            String[] wordSplitArray = word.split(":");

            if ("verb".equals(wordSplitArray[0])) {
                // 说明是个动词
                System.out.println("动词：" + wordSplitArray[1]);
                verbOutputStream.write(wordSplitArray[1].getBytes());
                verbOutputStream.write("\n".getBytes());
            } else if ("noun".equals(wordSplitArray[0])) {
                // System.out.println("名词：" + wordSplitArray[1]);
                nounOutputStream.write(wordSplitArray[1].getBytes());
                nounOutputStream.write("\n".getBytes());
            }
        }

        verbOutputStream.close();
        nounOutputStream.close();
    }

}
