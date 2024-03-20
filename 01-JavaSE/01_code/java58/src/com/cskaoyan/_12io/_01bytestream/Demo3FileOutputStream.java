package com.cskaoyan._12io._01bytestream;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Common-zhou
 * @since 2024-03-20 10:32
 */
public class Demo3FileOutputStream {

    @Test
    public void test1() {
        // 如何进行异常处理。

        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("2.txt");

            outputStream.write("hello exception".getBytes());
            outputStream.write("hello exception again".getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }

        }

    }

    @Test
    public void test2() {
        // try-with-resource
        // 如果有一些资源需要关闭。 JDK提供了一个方便的写法。

        // try(一些资源，资源一定要实现AutoCloseable接口){
        //    可以用这些资源
        // }
        // 等到大括号中代码执行完毕， close方法会自动调用。

        try (OutputStream outputStream = new FileOutputStream("2.txt")) {
            outputStream.write("helloworld".getBytes());

            // Redundant 'close()'
            // outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 等到代码执行完毕，close方法，会被自动调用
    }


    @Test
    public void test3() {
        try (MyResource myResource = new MyResource()) {
            myResource.test1();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // try-with-resource 语法。只要你按照这个格式写。  实现了AutoCloseable接口。最终JDK会帮你调用你的close方法。
    }

}


class MyResource implements AutoCloseable {

    @Override
    public void close() throws Exception {
        // 这个close一旦打印，说明close方法被调用了
        System.out.println("MyResource close method");
    }

    public void test1() {
        System.out.println("MyResource  test1");
    }
}
