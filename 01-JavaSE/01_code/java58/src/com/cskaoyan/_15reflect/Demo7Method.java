package com.cskaoyan._15reflect;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Common-zhou
 * @since 2024-03-25 17:57
 */
public class Demo7Method {
    @Test
    public void test1() {

        // Method[] getMethods()   // 父类的也能获取到
        // Method[] getDeclaredMethods()

        Class<User7> user7Class = User7.class;

        Method[] methods = user7Class.getMethods();
        System.out.println("getMethods=============================");
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("getDeclaredMethods=========================================");

        Method[] declaredMethods = user7Class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

    @Test
    public void test2() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class<User7> user7Class = User7.class;

        User7 user7 = new User7();


        // 方法的名字
        Method method = user7Class.getMethod("publicMethod", String.class);

        // 还有返回值。
        Object invoke = method.invoke(user7, "112324566");

        // method.setAccessible();

    }
}

class User7 {
    private void privateMethod() {
        System.out.println("private method");
    }

    void defaultMethod() {
        System.out.println("private method");
    }

    public void publicMethod() {
        System.out.println("public  method");
    }

    public void publicMethod(String name) {
        System.out.println("public  method" + name);
    }
}
