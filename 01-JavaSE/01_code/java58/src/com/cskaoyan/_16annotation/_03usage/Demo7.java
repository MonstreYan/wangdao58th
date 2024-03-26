package com.cskaoyan._16annotation._03usage;

/**
 * 1.注解的使用，每一个属性都需要赋值。
 * 赋值的方式  @注解名(属性名=属性值, 属性名2=属性值2)
 * 2.可以不赋值,但是要有默认值, default
 *
 * @author Common-zhou
 * @since 2024-03-26 14:52
 */
// 'name' missing though required
@MyAnnotation71(name = "zhangsan")
// 'name', 'country' missing though required
@MyAnnotation72(name = "lisi")
public class Demo7 {

}


@interface MyAnnotation71 {
    String name();
}

// 可以不赋值,但是要有默认值, default
@interface MyAnnotation72 {
    String name();

    String country() default "China";
}
