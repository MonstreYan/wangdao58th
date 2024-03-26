package com.cskaoyan._16annotation._01introduct;

/**
 * 注解就是一些额外的信息。
 * <p>
 * 权限修饰符 @interface 注解名{
 * // 在这里面可以写属性 这个就是定义了一个属性。
 * 属性类型 属性名();
 * }
 * <p>
 * <p>
 * 属性的类型只能有以下几种。
 * 基本数据类型
 * String类型
 * Class类型
 * 注解类型
 * 枚举类型
 * 以及以上类型的数组形式
 *
 * @author Common-zhou
 * @since 2024-03-26 14:30
 */
public class Demo4 {

}

// 这个就是定义了一个注解。 MyAnnotation4
@interface MyAnnotation4 {
    // 数据类型  属性名();
    int age();

    String value();
    Class loadClass();

}
