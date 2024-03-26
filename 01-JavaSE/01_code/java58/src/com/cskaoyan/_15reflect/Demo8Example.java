package com.cskaoyan._15reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射其实就是JVM提供的，运行时操作类对象的方式。
 * <p>
 * 在工作中，一般使用字符串来创建对象，来设置属性的任务。
 * <p>
 * 在txt里面。 有很多行。 第一行是你要创建的类的名字（全限定类名）。
 * 第二行开始。 都是以  key=value的形式给你的东西。  name=zs
 * 你的任务，就是要创建一个这样的对象出来。属性全部设置进去。
 * <p>
 * 反射提供了一种，以字符串形式，操作对象的方式。 比如创建对象， 比如设置属性，比如调用方法。
 *
 * 刚开始学反射，绕不过来。 反射里面操作的东西都是字符串。 将字符串形式，转换为实际的运行时对象。
 * new User8()
 * user8.name="12354665"
 *
 * @author Common-zhou
 * @since 2024-03-26 09:32
 */
public class Demo8Example {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        String content = readFileAndReturnContent(new File("src/com/cskaoyan/_15reflect/newuser" + ".txt"));

        // System.out.println(content);
        // String[] split里面是什么东西？
        // [com.cskaoyan.User8, name=zhangsan, address=hubei, email=10500@qq.com]
        String[] split = content.split("\n");

        // Bean   豆子 就是大家使用  User  Student  这种用来装数据的类
        String needInitBeanName = split[0];

        Class<?> aClass = Class.forName(needInitBeanName);

        Object inited = initBean(needInitBeanName);

        System.out.println(inited);

        // [com.cskaoyan.User8, name=zhangsan, address=hubei, email=10500@qq.com]
        // 对象有了。 属性。
        for (int i = 1; i < split.length; i++) {

            // name=zhangsan
            String fieldNameAndValue = split[i];

            String[] nameAndValue = fieldNameAndValue.split("=");

            setFieldValue(aClass, inited, nameAndValue[0], nameAndValue[1]);
        }

        System.out.println(inited);
    }

    /**
     * 传入一个obj对象。然后将这个obj对象， 的属性设置进去。
     * @param aClass
     * @param obj
     * @param fieldName
     * @param fieldValue
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    private static void setFieldValue(Class aClass, Object obj, String fieldName, String fieldValue) throws IllegalAccessException, NoSuchFieldException {

        Field declaredField = aClass.getDeclaredField(fieldName);

        System.out.println(declaredField + "===" + fieldName + "===" + fieldValue);

        declaredField.setAccessible(true);

        // 给这个对象的。 这个属性赋值。
        // declaredField 可以确定这是哪个属性。
        // 属性是依赖于对象存在的。 需要告诉它对象是谁。属性值是谁。
        declaredField.set(obj, fieldValue);
    }

    private static Object initBean(String needInitBeanName) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        // needInitBeanName needInitBeanName1 = new needInitBeanName();
        // Class对象。
        // User8.class;
        // User8 user8 = new User8();
        // user8.getClass();
        Class<?> aClass = Class.forName(needInitBeanName);

        Constructor<?> constructor = aClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        Object o = constructor.newInstance();
        // System.out.println(o);

        return o;
    }

    private static String readFileAndReturnContent(File file) throws IOException {

        InputStream inputStream = new FileInputStream(file);
        StringBuilder stringBuilder = new StringBuilder();

        byte[] bytes = new byte[2048];
        int len = -1;
        while ((len = inputStream.read(bytes)) != -1) {
            stringBuilder.append(new String(bytes, 0, len));
        }
        // System.out.println(stringBuilder);
        inputStream.close();

        return stringBuilder.toString();
    }
}

class User8 {
    private String name;
    private String address;
    private String phone;
    private String email;

    private User8() {
    }

    @Override
    public String toString() {
        return "User8{" + "name='" + name + '\'' + ", address='" + address + '\'' + ", phone='" + phone + '\'' + ", email='" + email + '\'' + '}';
    }
}


class Student8 {
    private String name;
    private String nickName;

    private Student8() {
    }

    @Override
    public String toString() {
        return "Student8{" + "name='" + name + '\'' + ", nickName='" + nickName + '\'' + '}';
    }
}
