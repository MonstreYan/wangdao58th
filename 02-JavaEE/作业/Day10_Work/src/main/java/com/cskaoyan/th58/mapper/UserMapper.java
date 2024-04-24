package com.cskaoyan.th58.mapper;

import com.cskaoyan.th58.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    //注册
    void insertUser(User user);

    //登录
    User selectUser(@Param("name") String userMessage,@Param("password") String password);

    //销户:对应的sql语句应该是删除数据库；但是真实的环境下，可能并没有删除，取决于公司有没有真正想把你删除
    void deleteUser(Integer id);
}
