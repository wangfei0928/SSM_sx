package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("/login")
//    public ModelAndView login(HttpServletRequest request) throws UnsupportedEncodingException {
//        request.setCharacterEncoding("utf-8");
//        String uname = request.getParameter("uname");
//        String password = request.getParameter("password");
//        System.out.println(uname);
//        System.out.println(password);
//        return null;
//    }


//    public ModelAndView login(@RequestParam("uname") String unames, @RequestParam("password") String passwords){
//        System.out.println(unames);
//        System.out.println(passwords);
//        return null;
//    }

    public ModelAndView login(String uname,  String password){   //当传入的参数  和前端页面的标签的name相同时，可以不写@RequestParam("uname")
        System.out.println(uname);
        System.out.println(password);
        return null;
    }


}
