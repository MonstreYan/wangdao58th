package com.cskaoyan._12io._01bytestream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * 输出流： 从内存中，往外部文件写。
 * 输入流： 从外部文件，往程序中读。
 *
 * @author Common-zhou
 * @since 2024-03-20 11:24
 */
public class Demo6 {
    @Test
    public void test1() throws IOException {
        // 输入流： 从文件中读数据进来。
        InputStream inputStream = new FileInputStream("2.txt");

        int read = inputStream.read();

        //  a   b  c  d  e  f
        //                     |
        // 一定是指向缝里面的。

        System.out.println(read);
        System.out.println(inputStream.read());
        System.out.println(inputStream.read());
        System.out.println(inputStream.read());
        System.out.println(inputStream.read());
        System.out.println(inputStream.read());
        System.out.println(inputStream.read());

        // read的时候，指针不断往后挪动。 直到移动到最后一个，返回-1表示结束

        inputStream.close();

    }


    @Test
    public void test2() throws IOException {
        // 怎么读取一个文件中所有的东西。

        InputStream inputStream = new FileInputStream("2.txt");

        // 写法1
        // while (true) {
        //     int readValue = inputStream.read();
        //
        //     if (readValue == -1) {
        //         break;
        //     }
        //     System.out.println(readValue);
        // }


        // 写法2
        int readValue = -1;
        while ((readValue = inputStream.read()) != -1) {
            System.out.println(readValue);
        }
    }

    @Test
    public void test3() throws IOException {

        // =============================写得时候一定要注意这个问题。
        InputStream inputStream = new FileInputStream("2.txt");
        //    a    b    c    d    e     f
        //                      |

        while ((inputStream.read()) != -1) {
            System.out.println(inputStream.read());
        }
        // read一下，会往后挪。 所以，read了之后，一定要用 一个值给它存起来。 不要用一下read一下。 有可能不是上一次read的值。
    }


    @Test
    public void test4() throws IOException {
        InputStream inputStream = new FileInputStream("2.txt");

        // 写法2
        int readValue = -1;
        while ((readValue = inputStream.read()) != -1) {
            System.out.println((char) readValue);
        }
    }


    @Test
    public void test5() throws IOException {
        InputStream inputStream = new FileInputStream("2.txt");

        // read一个byte数组。 就相当于使用这个byte数组来装数据。返回的int值就是装了多少个。
        // 如果返回为 -1。 代表完了。

        byte[] bytes = new byte[2];
        int readCount = inputStream.read(bytes);

        System.out.println("================");
        System.out.println(readCount);
        System.out.println(Arrays.toString(bytes));

        readCount = inputStream.read(bytes);
        System.out.println("================");
        System.out.println(readCount);
        System.out.println(Arrays.toString(bytes));

        readCount = inputStream.read(bytes);
        System.out.println("================");
        System.out.println(readCount);
        System.out.println(Arrays.toString(bytes));

        // new byte[2]
        //   a  b   c  d  e
        //               |
    }

    @Test
    public void test6() throws IOException {
        // read(byte[])
        // 使用你传入的字节数组来存储数据。返回的int表示返回的数据个数

        InputStream inputStream = new FileInputStream("2.txt");

        // 如何使用byte数组，将所有的数据，全读回来。
        byte[] bytes = new byte[2048];

        int readCount = 0;
        while ((readCount = inputStream.read(bytes)) != -1) {
            // bytes
            String s = new String(bytes, 0, readCount);
            System.out.println(s);
        }
    }

    @Test
    public void test7() throws IOException {

        InputStream inputStream = new FileInputStream("3.txt");

        // 如何使用byte数组，将所有的数据，全读回来。
        byte[] bytes = new byte[2048];

        int readCount = 0;
        while ((readCount = inputStream.read(bytes)) != -1) {
            // bytes
            // 默认是UTF-8. 现在文件也是UTF-8
            // String s = new String(bytes, 0, readCount, "UTF-8");
            String s = new String(bytes, 0, readCount, "GBK");
            System.out.println(s);
        }
    }
}
