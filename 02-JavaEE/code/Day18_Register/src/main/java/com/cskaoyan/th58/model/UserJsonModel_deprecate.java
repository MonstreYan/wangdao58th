package com.cskaoyan.th58.model;

import com.cskaoyan.th58.controller.UserController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/3 11:29
 * @Version 1.0
 */
public class UserJsonModel_deprecate {

    //制定了三个状态码：200表示注册成功；404表示用户名已经被占用；500表示服务器繁忙
    public static Integer register(User user){
        String path = UserController.class.getClassLoader().getResource("users.json").getPath();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String content = bufferedReader.readLine();
            ObjectMapper objectMapper = new ObjectMapper();
            List<User> registeredUsers = new ArrayList<>();
            //文件里面的数据存储的是用户的信息，应该是一个json字符串，但是要考虑到文件为空的情况
            if(!StringUtils.isEmpty(content)){
                //不为空-----说明有人注册过程
                TypeFactory typeFactory = objectMapper.getTypeFactory();
                CollectionType collectionType = typeFactory.constructCollectionType(List.class, User.class);
                registeredUsers = objectMapper.readValue(content, collectionType);
                for (User registeredUser : registeredUsers) {
                    if(user.getUsername().equals(registeredUser.getUsername())){
                        return 404;
                    }
                }
            }
            registeredUsers.add(user);
            //空，说明直接没有人注册过，直接注册即可，无需去做任何的校验判断

            //最后，把registeredUsers全量的数据写回到文件中
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(objectMapper.writeValueAsString(registeredUsers));
            fileWriter.flush();
            fileWriter.close();
            return 200;
        } catch (Exception e) {

        }
        return 500;
    }
}
