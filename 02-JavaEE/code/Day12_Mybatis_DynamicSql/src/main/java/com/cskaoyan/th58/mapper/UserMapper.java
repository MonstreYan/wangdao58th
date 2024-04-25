package com.cskaoyan.th58.mapper;

import com.cskaoyan.th58.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> selectByCondition(@Param("username") String username,@Param("id") Integer id,@Param("phone") String phone);

    List<User> selectByCondition2(@Param("username") String username, @Param("phone") String phone, @Param("email") String email, @Param("password")String password);
}
