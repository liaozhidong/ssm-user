package com.spring.controller;

import com.spring.converter.DateConverter;
import com.spring.entity.User;
import com.spring.service.UserService;
import com.spring.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //登录
    @ResponseBody
    @RequestMapping(value = "/checkLogin",produces = {"application/json;charset=UTF-8" })
    public User checkLogin(@RequestBody User user, Model model, HttpSession session) {
        User user1 = userService.CheckLoginAndPwd(user.getUsername(),user.getPassword());
        session.setAttribute("user1",user1);
        return user1;
    }

    //注销
    @RequestMapping("/LogOut")
    public String LogOut(HttpSession session) {
        session.invalidate();
        return "redirect:/Login.jsp";
    }

    //注册
    @RequestMapping(value = "/register",method={RequestMethod.GET,RequestMethod.POST})
    public String register(User user, Model model) {
        userService.addUser(user);
        model.addAttribute("msg","注册成功,请登陆");
        return "success";
    }

}
