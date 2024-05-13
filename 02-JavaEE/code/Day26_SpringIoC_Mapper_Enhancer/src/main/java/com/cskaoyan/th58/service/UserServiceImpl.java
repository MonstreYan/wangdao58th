package com.cskaoyan.th58.service;

import com.cskaoyan.th58.domain.User;
import com.cskaoyan.th58.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 15:15
 * @Version 1.0
 */
//需要对service实现类进行增强处理；需要再执行方法执行获取sesion，执行完方法之后session提交、关闭；还需要给mapper成员变量进行赋值
    //此时暂时不可以对成员变量使用@Autowired
@Service
public class UserServiceImpl implements UserService{

    UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insertOne(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectOne(id);
    }
}
