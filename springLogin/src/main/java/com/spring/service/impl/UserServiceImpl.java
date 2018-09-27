package com.spring.service.impl;

import com.spring.dao.UserMapper;
import com.spring.entity.User;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User CheckLoginAndPwd(String name, String pwd) {
        return userMapper.CheckLoginAndPwd(name,pwd);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
