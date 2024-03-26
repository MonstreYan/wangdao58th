package com.cskaoyan._16annotation._04ex;

/**
 * 注解一般用来提供一些额外的信息。
 * 通过注解的名字，给你提供一些额外的信息。让你见到这个注解。就大致知道这个注解的作用。
 *
 * @author Common-zhou
 * @Validate();
 * @Cache() // 一般对于用户名和密码 。
 * // 最小长度，最大长度得校验。   是否允许为null     报错的信息，也得告诉别人
 * @since 2024-03-26 15:03
 */
public class Demo1 {
    public static void main(String[] args) {
        User1 user1 = new User1();

        test1();

    }

    private static void test1() {
        test2();
    }

    private static void test2() {
        test3();
    }

    private static void test3() {
        validateUser(null);

    }

    private static void validateUser(User1 user1) {
        if (user1 == null) {
            throw new IllegalArgumentException("user1 不能为null");
        }
        if (user1.username == null || (user1.username.length() < 6 || user1.username.length() > 18)) {
            throw new IllegalArgumentException("用户名不能为空，或者长度不在 6-18之间");
        }

    }
}


// 这里就可以通过注解的形式，提供一些额外的信息。 最后再集中处理。
class User1 {
    // name的值，是不是的校验一下
    // 最小长度，最大长度。 [6,18] .不允许为null。报错信息
    String username;
    String password;

    // 假设可以为空。 但是不为空的时候，也得校验长度。
    String email;
}
