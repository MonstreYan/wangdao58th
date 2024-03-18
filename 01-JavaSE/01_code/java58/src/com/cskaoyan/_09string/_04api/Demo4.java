package com.cskaoyan._09string._04api;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author Common-zhou
 * @since 2024-03-18 15:25
 */
public class Demo4 {
    @Test
    public void test1() {
        // 获取一个用来表示字符串对象字符序列的，字节数组
        // byte[] getBytes()
        // 获取的是用来表示字符串对象字符序列的，字符数组
        // char[] toCharArray()

        String s = "abcaaabbb";

        byte[] bytes = s.getBytes();
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
    }

    @Test
    public void test2() {
        String s = "abcaaabbb";

        char[] charArray = s.toCharArray();

        for (char charAt : charArray) {
            System.out.println(charAt);
        }
    }

    @Test
    public void test3() {

        char[] chars = {'景', '天', '老', '师', '又', '来', '了'};

        // 把字符数组转换成字符串
        // static String valueOf(char[] chs)
        String s = String.valueOf(chars);
        System.out.println(s);

        // 把各种基本数据类型和对象转换成字符串  100---> "100"
        // static String valueOf(int i/double...)
    }

    @Test
    public void test4() {
        // 把字符串全部转化为小写
        // String toLowerCase()
        // 把字符串全部转换为大写
        // String toUpperCase()

        String s1 = "helloWorld";
        // 转换为小写。 是在原本的基础上转换。还是新建一个、
        // String: 不可变。
        String lowerCase = s1.toLowerCase();

        System.out.println(s1);
        System.out.println(lowerCase);

        String upperCase = s1.toUpperCase();
        System.out.println(upperCase);

        // 字符串拼接，作用等价于 + 实现的字符串拼接
        // String concat(String str)

        String concat = s1.concat("1111");
        System.out.println(concat);
    }

    @Test
    public void test6Example() {
        // 1:字符串helloWORLD
        // 2:第一个字符转为大写,其余字符转为小写     →   Helloworld

        String s = "helloWORLD";
        String s1 = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();

        System.out.println(s1);
    }

    @Test
    public void test7Example2() {
        // 1:字符串反转
        // 2:举例:
        // 键盘输入abc,反转后结果为cba

        Scanner scanner = new Scanner(System.in);
        // abc    cba
        String inputString = scanner.nextLine();


        // 倒序遍历。 然后拼接

        // abcabc
        // cbacba

        String reverseString = "";
        for (int i = inputString.length() - 1; i >= 0; i--) {
            char charAt = inputString.charAt(i);
            reverseString += charAt;
        }

        System.out.println(reverseString);


    }


}
