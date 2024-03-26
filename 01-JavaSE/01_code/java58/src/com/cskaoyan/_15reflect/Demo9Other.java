package com.cskaoyan._15reflect;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Common-zhou
 * @since 2024-03-26 10:29
 */
public class Demo9Other {
    @Test
    public void test1() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> aClass = Class.forName("com.cskaoyan._15reflect.User9");

        System.out.println("aClass.getName() = " + aClass.getName());

        System.out.println("aClass.getSimpleName() = " + aClass.getSimpleName());

        Class<?> superclass = aClass.getSuperclass();

        System.out.println(superclass.getName());

        Class<?>[] interfaces = aClass.getInterfaces();

        for (Class<?> anInterface : interfaces) {
            System.out.println("anInterface = " + anInterface);
        }


        // aClass User9 这个Class
        int modifiers = aClass.getModifiers();
        System.out.println("Modifier.toString(modifiers) = " + Modifier.toString(modifiers));

        Method method = aClass.getDeclaredMethod("run");

        int modifiers1 = method.getModifiers();
        System.out.println("Modifier.toString(modifiers1) = " + Modifier.toString(modifiers1));

    }
}

class User9 extends Demo9Other implements Runnable, Comparable {

    private String name;


    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public void run() {

    }
}
