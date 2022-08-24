package com.example.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/fn1")
    @RequiresRoles("putong")
    public String fn1(){
        System.out.println("fn1方法");
        return "";
    }


    @RequiresRoles("niubi")
    @RequestMapping("/fn2")
    public String fn2(){
        System.out.println("fn2");
        return "";
    }
}
