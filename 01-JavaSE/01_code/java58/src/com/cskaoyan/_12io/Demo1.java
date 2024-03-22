package com.cskaoyan._12io;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Common-zhou
 * @since 2024-03-22 09:31
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        // 从磁盘上读取一个文本文件（如某个java源代码），
        // 分别统计出文件里英文字母、空格、数字字符的个数。
        // (注意文本文件中的数字指的是数字字符！！！)


        // 怎么做？
        // 0. 创建三个变量，用来存储这些数据。
        int countLetter = 0;
        int countWhiteSpace = 0;
        int countDigit = 0;

        // 1.用io流。 字符流将数据读进来。
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/com/cskaoyan/_12io/Demo1.java"));


        while (true) {
            String s = bufferedReader.readLine();

            if (s == null) {
                break;
            }

            // 得到一行一行的数据 String line 。 怎么将这个东西
            // public class Demo1 {   在里面写if。   如果是英文（）
            //
            for (int i = 0; i < s.length(); i++) {
                char charAt = s.charAt(i);

                if (charAt == ' ') {
                    countWhiteSpace++;
                } else if (charAt >= '0' && charAt <= '9') {
                    countDigit++;
                } else if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                    // a 97   z
                    // A 65   Z90
                    countLetter++;
                }

            }

        }


        // 一般情况下，很多时候就是遍历。
        // 让你找符合条件的学生。

        // Student[] students =

        System.out.println("countDigit = " + countDigit);
        System.out.println("countWhiteSpace = " + countWhiteSpace);
        System.out.println("countLetter = " + countLetter);


        // 找出高于平均分的学生
        // Student[] students =
        // 先求平均分；
        // 遍历的方法一定要特别熟悉。

    }
}
