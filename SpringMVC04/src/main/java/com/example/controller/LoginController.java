package com.example.controller;

import com.example.bean.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public String login(String uname, String password, HttpSession session){
        User user = userService.login(uname, password);
        if (user != null){
            //登陆成功
            session.setAttribute("isLogin",uname);
            return "forward:/product/toList";
        }else {
            return "redirect:/login.jsp";
        }

    }
}
