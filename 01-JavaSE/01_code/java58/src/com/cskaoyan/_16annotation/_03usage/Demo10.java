package com.cskaoyan._16annotation._03usage;

/**
 * 5.如果属性类型是引用类型, 值不能是null
 *
 * @author Common-zhou
 * @since 2024-03-26 15:01
 */
// @MyAnnotation10(name = null)
public class Demo10 {

}

@interface MyAnnotation10 {
    String name();
}
