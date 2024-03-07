package com.cskaoyan._04oop1._15modifier._pack1;

/**
 * @author Common-zhou
 * @since 2024-03-07 17:38
 */
public class Student {
    public String publicStringName = "public value";

    // 默认控制权限。
    String defaultStringName = "default value";

    private String privateStringName = "private value";


    public void test1() {
        System.out.println(privateStringName);
    }
}
