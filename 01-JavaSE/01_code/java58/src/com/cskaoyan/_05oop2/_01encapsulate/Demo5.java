package com.cskaoyan._05oop2._01encapsulate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 定义一个银行账户类Account, 3个属性, 用户名, 密码, 余额.
 * 要求用户名长度
 * 密码长度6位。余额不能修改
 * <p>
 * <p>
 * 假设。我想校验密码。 必须有大写，有小写，有数字 ，有特殊符号。4种中的三种。在Java中。
 * 长度也有限制。 弱密码。
 * 现在，怎么办？ ===》 GPT。
 *
 * @author Common-zhou
 * @since 2024-03-08 15:07
 */
public class Demo5 {
    public static void main(String[] args) {
        Account1 account1 = new Account1();

        account1.setPassword("admin");
        account1.setPassword("admin123");
        account1.setPassword("adminABC!");
        account1.setPassword("a11111111111111!");

        System.out.println("account1.getPassword() = " + account1.getPassword());
    }
}

class Account1 {
    // alt 按住。 多选行。
    private String name;
    private String password;
    private int balance;

    // set方法中限制。

    public String getName() {
        return name;
    }

    public void setName(String name) {

        // 用户名 4-6位。
        if (name.length() < 4 || name.length() > 6) {
            // 不符合规范。
            System.out.println("用户名不符合规范，" + name);
            return;
        }

        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        if (!isValidPassword(password)) {
            System.out.println("密码不符合规范");
            return;
        }
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public static boolean isValidPassword(String password) {
        // 正则表达式匹配大写字母、小写字母、数字和特殊符号中的至少三种
        // String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[@$!%*?&])[A-Za-z\\\\d@$!%*?&]{8,}$";
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]|.*?[#?!@$%^&*-])(?=.*?[#?!@$%^&*-]|.*?[0-9]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
