package com.spring.service;

import com.spring.entity.User;

public interface UserService {

    //查询用户名跟密码
    User CheckLoginAndPwd(String name, String pwd);

    //注册用户
    void addUser(User user);
}
