package com.cskaoyan.th58.factorBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/11 11:06
 * @Version 1.0
 */
public class UserFactorBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
