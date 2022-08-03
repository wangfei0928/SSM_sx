package com.example.controller;

import com.example.service.IService;
import com.example.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    @Autowired
    private IService service;

    public void myQuery(){
        service.query();
    }
}
