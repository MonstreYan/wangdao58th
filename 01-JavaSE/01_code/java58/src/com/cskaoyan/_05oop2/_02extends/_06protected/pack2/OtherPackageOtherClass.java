package com.cskaoyan._05oop2._02extends._06protected.pack2;

import com.cskaoyan._05oop2._02extends._06protected.pack1.OnePackageClass;

/**
 * 不同包，不同类
 *
 * @author Common-zhou
 * @since 2024-03-08 17:42
 */
public class OtherPackageOtherClass {
    public static void main(String[] args) {
        OnePackageClass onePackageClass = new OnePackageClass();
        String publicStringName = onePackageClass.publicStringName;
        // 在不同包，非子类。无法使用这个变量
        // String protectedStringName = onePackageClass.protectedStringName;
    }
}
