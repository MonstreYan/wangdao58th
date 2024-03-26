package com.cskaoyan._16annotation._03usage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author Common-zhou
 * @Target元注解，注解可以作用的目标，注解可以放在哪些位置。 对于注解而言，可以作用的目标：
 * 1. ElementType.TYPE：可以用于类、接口、枚举（enum）
 * 2. ElementType.FIELD： 可以用于字段（成员变量）
 * 3. ElementType.CONSTRUCTOR： 可以用于构造方法
 * 4. ElementType.METHOD： 可以用于方法
 * @since 2024-03-26 14:45
 */
// @MyAnnotation6
public class Demo6 {
    // @MyAnnotation6
    String name;

    @MyAnnotation6
    public void test1(){

    }
}


// 加上了@Target之后。 就可以控制这个注解。能放在哪些位置。
@Target(value = ElementType.METHOD)
@interface MyAnnotation6 {

}
