package com.cskaoyan.th58.mapper;

import com.cskaoyan.th58.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    //注册
    void insertUser(@Param("u") User user, @Param("tb_name") String tbName);
    //登录

    User selectUser(@Param("name") String name,@Param("password") String password,@Param("tb_name") String tbName);
}
