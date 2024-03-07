package com.cskaoyan._04oop1._15modifier._pack2;


import com.cskaoyan._04oop1._15modifier._pack1.Student;

/**
 * @author Common-zhou
 * @since 2024-03-07 17:39
 */
public class Demo2 {
    public static void main(String[] args) {
        Student student = new Student();

        String publicStringName = student.publicStringName;
        System.out.println(publicStringName);

        // defaultStringName' is not public in 'com.cskaoyan._04oop1._15modifier._pack1.Student'.
        // Cannot be accessed from outside package
        // 看报错能得到的提示。
        // String defaultStringName = student.defaultStringName;

        // String privateStringName = student.privateStringName;
    }
}
