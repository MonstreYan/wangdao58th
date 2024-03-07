package com.cskaoyan._04oop1._15modifier._pack1;

/**
 * 1.在同类下。 哪些方法能访问？
 * 所有的东西都可以访问
 * 2.如果在 pack1包下。 有个类。 能访问哪些东西？
 * public default
 * 3.如果在pack2 包下
 * public能访问。
 * <p>
 * 在工作中，全用public
 *
 * @author Common-zhou
 * @since 2024-03-07 17:50
 */
public class Teacher {

    private String privateStringName = "private String value";
    String defaultStringName = "default String value";
    public String publicStringName = "public String value";


    private void privateMethod() {
        System.out.println("private method");
    }

    void defaultMethod() {
        System.out.println("default method");
    }

    public void publicMethod() {
        System.out.println("public method");
    }


}
