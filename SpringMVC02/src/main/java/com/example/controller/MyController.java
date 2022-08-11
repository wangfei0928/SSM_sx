package com.example.controller;


import com.example.service.IMyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @Autowired
    private IMyService myService;


    @RequestMapping("/abc")//相当于映射处理器和适配器
    public ModelAndView fn1(){
        myService.fn1();
      return   new ModelAndView("ttt");
    }

    @RequestMapping("/req")
    public ModelAndView fn2(@RequestAttribute String sname){
        System.out.println(sname);
        return null;
    }


    @RequestMapping("/session")
    public ModelAndView fn3(@SessionAttribute String pname){
        System.out.println(pname);
        return null;
    }

    @RequestMapping("/cookie")
    public ModelAndView fn4(@CookieValue String hobby){
        System.out.println(hobby);
        return null;
    }
}
