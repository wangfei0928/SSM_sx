package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DelController {

    @RequestMapping("/user/{id}")
    public String del(@PathVariable Integer id){
        System.out.println(id);
        return "hello";
    }
}
