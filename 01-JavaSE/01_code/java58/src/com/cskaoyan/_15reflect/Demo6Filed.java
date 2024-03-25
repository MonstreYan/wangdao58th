package com.cskaoyan._15reflect;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author Common-zhou
 * @since 2024-03-25 17:44
 */
public class Demo6Filed {

    @Test
    public void test1() {

        Class<User6> user6Class = User6.class;

        Field[] fields = user6Class.getFields();

        System.out.println("getFields======================================");
        for (Field field : fields) {
            System.out.println(field);
        }


        Field[] declaredFields = user6Class.getDeclaredFields();

        System.out.println("declaredFields=====================================");
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }


    @Test
    public void test2() throws NoSuchFieldException {
        Class<User6> user6Class = User6.class;
        // java.lang.NoSuchFieldException: privateString
        try {
            Field field = user6Class.getField("privateString");
            System.out.println(field);
        } catch (NoSuchFieldException e) {
            // System.out.println("===================");
            e.printStackTrace();
            // throw new RuntimeException(e);
        }


        Field field = user6Class.getDeclaredField("privateString");
        System.out.println(field);

    }

    @Test
    public void test3() throws NoSuchFieldException, IllegalAccessException {
        // 通过 Field对象，对属性进行设置。
        Class<User6> user6Class = User6.class;

        Field field = user6Class.getField("publicString");

        User6 user6 = new User6();
        user6.publicString = "pppppppppp";
        user6.publicString2 = "pppppppppp2222222222";

        // Filed是属性。
        // 成员变量依赖于谁？  对象。所以get的时候，一定要传入一个独享。
        Object o = field.get(user6);

        System.out.println(o);
    }


    @Test
    public void test4() throws NoSuchFieldException, IllegalAccessException {
        Class<User6> user6Class = User6.class;

        Field privateStringField = user6Class.getDeclaredField("privateString");

        User6 user6 = new User6();

        privateStringField.setAccessible(true);
        Object o = privateStringField.get(user6);

        System.out.println(o);

        privateStringField.set(user6, "111111111");

        System.out.println("user6.getPrivateString() = " + user6.getPrivateString());


    }
}

class User6 {
    private String privateString = "privateString......";
    String defaultString;
    public String publicString;
    public String publicString2;


    public String getPrivateString() {
        return privateString;
    }
}
