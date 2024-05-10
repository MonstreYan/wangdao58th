package com.cskaoyan.market.preview;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/10 14:47
 * @Version 1.0
 */
public class ProxyDemo {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserService proxy = (UserService) DynamicProxyUtils.getProxy(userService);
        //固定地去调用invocationHandler.invoke()方法
        proxy.addUser();

        proxy.selectUser();
    }
}
