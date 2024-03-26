package com.cskaoyan._16annotation._04ex;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * 用注解的形式，处理这种额外信息。
 * 写代码来完成这种真实的校验。
 * 现在，是想写一个通用的校验逻辑。  User2  Student2
 *
 * 注解，就是提供一些额外的信息。 比如，校验的时候的长度校验。
 * 可以通过反射的方式让代码的通用性增强。
 *
 * 反射可以让代码更通用。一般它用在框架的底层。
 *
 * @author Common-zhou
 * @since 2024-03-26 15:13
 */
public class Demo2 {

    public static void validateObject(Object object) throws IllegalAccessException {

        // 假设这个 Object 可能是 User2  可能是  Teacher2   可能是Student2.

        Class<?> objectClass = object.getClass();

        Field[] declaredFields = objectClass.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            // 这个地方的 field  ，就是  username   password   email
            // Object value = declaredField.get(object);
            Object value = declaredField.get(object);

            Validation validationFound = declaredField.getAnnotation(Validation.class);

            if (validationFound != null) {
                // 上面有这个注解。需要校验。

                if (value == null) {
                    if (!validationFound.allowNull()) {
                        // 说明不符合规范。
                        throw new IllegalArgumentException(declaredField.getName() + " 不允许为null" + "，但是值为null");
                    }
                    continue;
                }

                // 走到这，说明啥？ 说明 value不为空.
                String valueString = (String) value;

                if (valueString.length() < validationFound.minLength() || valueString.length() > validationFound.maxLength()) {
                    throw new IllegalArgumentException(validationFound.errorMsg());
                }
            }

        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        User2 user2 = new User2();
        user2.username = "123456";
        user2.password = "1234567891";
        // user2.email = "1234567";

        validateObject(user2);

        System.out.println("==========================");
        User21 user21 = new User21();
        validateObject(user21);

    }


}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Validation {
    int minLength();

    int maxLength();

    boolean allowNull();

    String errorMsg();
}

class User2 {
    // name的值，是不是的校验一下
    // 最小长度，最大长度。 [6,18] .不允许为null。报错信息
    @Validation(minLength = 6, maxLength = 18, allowNull = false, errorMsg = "用户名不允许为空，长度必须在[6," + "18]之间")
    String username;
    @Validation(minLength = 10, maxLength = 32, allowNull = false, errorMsg = "密码不允许为null， " + "长度必须在[10," + "32]之间")
    String password;

    // 假设可以为空。 但是不为空的时候，也得校验长度。
    @Validation(minLength = 8, maxLength = 24, allowNull = true, errorMsg = "邮箱允许为null，但是在不为null的时候，应该在[8,24]之间")
    String email;

    int age;
}


class User21 {
    @Validation(minLength = 3, maxLength = 10, allowNull = false, errorMsg = "id不允许为null， 长度应该在[3" + ",10]之间")
    String id;

    @Validation(minLength = 2, maxLength = 20, allowNull = true, errorMsg = "nickname允许为null， 长度[]")
    String nickname;

}
