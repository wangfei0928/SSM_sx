package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * restful风格
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @GetMapping("/getSome")
    public String getAll(){
        return "";
    }

    @PostMapping("/insert")
    public String insert(){
        return "";
    }

    @PutMapping("/update")
    public String update(){
        return  "";
    }

    @DeleteMapping("/delete")
    public String delete(){
        return "";
    }

}
