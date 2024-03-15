package com.cskaoyan._07object;

/**
 * finalize
 *
 * @author Common-zhou
 * @since 2024-03-15 15:58
 */
public class Demo9 {

    public static void main(String[] args) {
        new Student9();

        System.gc();

        // JVM
    }
}


class Student9 {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("模拟释放资源");
    }
}
