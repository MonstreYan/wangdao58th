package com.cskaoyan._05oop2._02extends._06protected.pack1;

/**
 * @author Common-zhou
 * @since 2024-03-08 17:37
 */
public class OnePackageClass {
    protected String protectedStringName = "protectedStringName";
    public String publicStringName = "publicStringName";

    // 在这能不能访问protected修饰的变量
    public void test1() {
        System.out.println(protectedStringName);
    }

}
