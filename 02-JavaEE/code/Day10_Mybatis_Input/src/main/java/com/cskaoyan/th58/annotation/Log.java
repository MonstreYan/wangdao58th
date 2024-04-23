package com.cskaoyan.th58.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//表示的是存在于哪个阶段，我们设置的是运行期间该注解还是存在的
@Retention(RetentionPolicy.RUNTIME)
//注解可以写在哪个头上；设置的是可以写在类的头上
@Target(ElementType.TYPE)
public @interface Log {

    String name() default "";
}
