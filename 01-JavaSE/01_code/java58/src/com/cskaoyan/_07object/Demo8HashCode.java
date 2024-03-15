package com.cskaoyan._07object;

import java.util.Objects;

/**
 * hashCode： 就是一个方法， 默认返回的是这个对象的地址。
 * 重写的时候，需要注意的问题。 要重写hashCode和equals方法，一起重写。 而且重写的依据必须要一样。(就是和这些东西相关。 )
 * <p>
 * 如果equals和name、age、phone相关，这时候hashCode的重写，也必须和这些相关。
 *
 * 面试题： 为啥hashCode和equals必须一起重写。
 *
 * @author Common-zhou
 * @since 2024-03-15 15:47
 */
public class Demo8HashCode {

}


class Student8 {
    String name;
    int age;
    String phone;
    String nickName;
    String comment;


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Student8 student8 = (Student8) object;
        return age == student8.age && Objects.equals(name, student8.name) && Objects.equals(phone, student8.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, phone);
    }
}
