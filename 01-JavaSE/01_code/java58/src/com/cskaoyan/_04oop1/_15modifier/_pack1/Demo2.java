package com.cskaoyan._04oop1._15modifier._pack1;

/**
 * @author Common-zhou
 * @since 2024-03-07 17:45
 */
public class Demo2 {
    public static void main(String[] args) {
        Student student = new Student();

        String publicStringName = student.publicStringName;
        String defaultStringName = student.defaultStringName;

        System.out.println(defaultStringName);

        // 'privateStringName' has private access
        // in 'com.cskaoyan._04oop1._15modifier._pack1.Student'
        // String privateStringName = student.privateStringName;
    }
}
