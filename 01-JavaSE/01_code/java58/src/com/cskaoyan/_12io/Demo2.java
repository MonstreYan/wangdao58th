package com.cskaoyan._12io;

import java.io.*;

/**
 * @author Common-zhou
 * @since 2024-03-22 09:55
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        // 递归查找指定目录中(包括子目录中)，所有的.java文件，
        // 并且，把所有这些找到的java文件的文件名，写入到一个指定文件中。

        // 1.找文件  获取目录下的所有文件。判断文件是否是 .java


        File file = new File("java_list.txt");

        OutputStream outputStream = new FileOutputStream(file);

        searchJavaFile(new File("src"), outputStream);

    }


    public static void searchJavaFile(File targetFile, OutputStream outputStream) throws IOException {


        // 先进行防御性编程。
        if (targetFile == null) {
            return;
        }

        // OutputStream outputStream = new FileOutputStream(outputFile, true);

        if (targetFile.isFile()) {
            // 是文件。判断。
            if (targetFile.getName().endsWith(".java")) {
                // System.out.println(targetFile.getName());
                outputStream.write(targetFile.getName().getBytes());
                outputStream.write("\n".getBytes());
            }
            return;
        }

        // 走到这，说明啥。
        File[] files = targetFile.listFiles();
        for (File childFile : files) {
            if (childFile.isFile()) {
                // 是文件。 只用判断后缀名。 是.java 找到了
                if (childFile.getName().endsWith(".java")) {
                    // System.out.println(childFile.getName());
                    outputStream.write(childFile.getName().getBytes());
                    outputStream.write("\n".getBytes());
                }
            } else if (childFile.isDirectory()) {
                searchJavaFile(childFile, outputStream);
            }

        }

    }
}
