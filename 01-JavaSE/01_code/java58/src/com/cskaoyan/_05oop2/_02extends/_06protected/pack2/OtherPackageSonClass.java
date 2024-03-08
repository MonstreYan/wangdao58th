package com.cskaoyan._05oop2._02extends._06protected.pack2;

import com.cskaoyan._05oop2._02extends._06protected.pack1.OnePackageClass;

/**
 * 另外的包。但是是子类
 *
 * @author Common-zhou
 * @since 2024-03-08 17:44
 */
public class OtherPackageSonClass extends OnePackageClass {

    public void test1() {
        System.out.println(this.protectedStringName);
    }

    public static void main(String[] args) {
        OnePackageClass onePackageClass = new OnePackageClass();
        // onePackageClass.publicStringName;
    }
}
