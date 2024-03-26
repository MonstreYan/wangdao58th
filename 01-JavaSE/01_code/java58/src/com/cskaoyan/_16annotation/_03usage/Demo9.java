package com.cskaoyan._16annotation._03usage;

/**
 * 4.如果只有1个属性, 名字叫value, 可以简化赋值
 * MyAnnotation9("123456")
 * 不用写value=
 *
 * @author Common-zhou
 * @since 2024-03-26 15:00
 */
// @MyAnnotation9(value = "123456")
@MyAnnotation9("123456")
public class Demo9 {

}

@interface MyAnnotation9 {
    // 这里面只有一个属性，而且属性的名字叫做 value
    String value();
}
