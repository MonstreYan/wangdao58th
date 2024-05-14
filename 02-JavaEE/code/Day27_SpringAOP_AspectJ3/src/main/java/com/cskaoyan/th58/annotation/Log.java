package com.cskaoyan.th58.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 10:03
 * @Version 1.0
 */
//注解需要一些元数据：1.注解可以写在哪些上面：类、方法、成员变量；2保留期：源码、class存在、运行时存在
    //表示的是当前注解可以写在方法的上面
@Target(ElementType.METHOD)
//运行时依然保留存在，只有设置runtime，那么才可以发挥功能  java------class--------运行(RUNTIME)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
}
