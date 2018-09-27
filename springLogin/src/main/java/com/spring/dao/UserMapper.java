package com.spring.dao;

import com.spring.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * lzd
 */
public interface UserMapper {

    //查询
    User CheckLoginAndPwd(@Param("username") String name, @Param("password") String pwd);

    //注册用户
    void addUser(User user);
}
