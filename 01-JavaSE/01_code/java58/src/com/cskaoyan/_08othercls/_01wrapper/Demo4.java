package com.cskaoyan._08othercls._01wrapper;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-15 17:23
 */
public class Demo4 {
    @Test
    public void test1() {
        // // 转换为小写
        // static char toLowerCase(char ch)
        // // 转换为大写
        // static char toUpperCase(char ch)
        // // 确定指定字符是否为大写字母
        // static boolean isUpperCase(char ch)
        // // 确定指定字符是否为小写字母
        // static boolean isLowerCase(char ch)
        // // 否为空格
        // static boolean isWhitespace(char ch)
        // // 确定指定字符是否为字母或数字
        // static boolean isLetterOrDigit(char ch)
        // // 确定指定字符是否为字母
        // static boolean isLetter(char ch)
        // // 确定指定字符是否为数字。
        // static boolean isDigit(char ch)

        // 一般情况不用记。 这些API，这些方法。 只要心里有大致印象，下一次看名字。就知道方法大致的作用。

        // 自动装箱。
        Character character = 'a';
        char upperCase = Character.toUpperCase(character);
        System.out.println(upperCase);

        System.out.println("Character.toLowerCase(character) = " + Character.toLowerCase(character));


    }
}
