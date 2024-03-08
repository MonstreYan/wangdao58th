package com.cskaoyan._05oop2._01encapsulate;

/**
 * 定义一个银行账户类Account, 3个属性, 用户名, 密码, 余额.
 * 要求用户名长度4-6位
 * 密码长度6位。余额不能修改
 *
 * @author Common-zhou
 * @since 2024-03-08 15:07
 */
public class Demo4 {
    public static void main(String[] args) {
        Account account = new Account();

        account.setName("admin");
        account.setPassword("12345");

        System.out.println("account.getName() = " + account.getName());
        System.out.println("account.getPassword() = " + account.getPassword());
    }
}

class Account {
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

        if (password.length() != 6) {
            // 不符合规范。
            System.out.println("密码不符合规范，" + password);
            return;
        }

        this.password = password;
    }

    public int getBalance() {
        return balance;
    }


}
