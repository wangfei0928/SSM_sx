package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(String uname, String password, HttpSession session){
        if (uname.equals("admin") && password.equals("123")){
            session.setAttribute("isLogin","OK");
            return "list";
        }else {
            return "redirect:/login.jsp";
        }
    }
}
