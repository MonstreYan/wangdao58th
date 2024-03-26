package com.cskaoyan._16annotation._02source;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 元注解： 就是注解的注解。(放在注解上的注解。 )。这个注解，使用描述注解的注解
 *
 * @author Common-zhou
 * @Retention元注解，来定义我们自己定义的注解的保留级别. 注解在程序运行时的生命周期。
 * @Retention有一个RetentionPolicy类型的属性，它可以设置为以下三个值之一： -
 * RetentionPolicy.RUNTIME： 运行时级别，它将被包含在编译后的字节码文件中，并在运行时保留，可以通过反射机制在运行时获取。这是最高的保留级别，允许在运行时通过反射检查和处理注解信息。
 * - RetentionPolicy.CLASS：  默认，它会被包含在编译后的字节码文件中，但在运行时会被丢弃。这意味着它对运行时的程序没有影响，只有在编译时才有用。
 * - RetentionPolicy.SOURCE： 意味着它仅存在于源代码中，在编译时被丢弃，不会包含在编译后的字节码文件中。这种类型的注解通常用于提供编译时的信息，例如代码检查工具或自动生成代码的工具。
 * @since 2024-03-26 14:34
 */
@MyAnnotation5
public class Demo5 {
    public static void main(String[] args) {
        System.out.println("hello world");

        Demo5 demo5 = new Demo5();

        Class<? extends Demo5> aClass = demo5.getClass();

        System.out.println("====================");
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        System.out.println("====================");
    }
}


@Retention(value = RetentionPolicy.RUNTIME)
// 就是描述。 这个注解，能够保留到什么时候。
// RetentionPolicy.SOURCE 只保留这个注解，在源代码阶段。 一旦代码编译，之后，注解会被丢掉。
// RetentionPolicy.CLASS：  默认，在编译的时候保留这个注解，但是程序一旦运行起来，这个注解会被丢掉。
// RetentionPolicy.RUNTIME： 运行时级别，
// 这玩意有什么用？ 可以控制注解的生命周期。有一些注解的信息，我希望在程序运行起来的时候，能够获取到。
@interface MyAnnotation5 {

}
