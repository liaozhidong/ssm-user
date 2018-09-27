package com.spring.inteceptor;

import com.spring.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 * lzd
 */
public class LoginIncetepor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object hander) throws Exception {
        //获取请求的URL地址
        String url = request.getRequestURI();
        if (url.indexOf("/checkLogin.action")>=0){
            return  true;
        }
        if (url.indexOf("/register.action")>=0){
            return  true;
        }
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user1");
        if (user!=null){
            return  true;
        }
        request.getRequestDispatcher("/Login.jsp").forward(request,response);
        return false;
    }

}
