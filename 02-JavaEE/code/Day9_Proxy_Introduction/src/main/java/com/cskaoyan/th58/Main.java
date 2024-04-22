package com.cskaoyan.th58;

import com.cskaoyan.th58.origin.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.addUser();

        userService.updateUser();

        userService.deleteUser();
    }
}