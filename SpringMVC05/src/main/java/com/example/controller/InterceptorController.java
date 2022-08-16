package com.example.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {

    @RequestMapping("/fn1")
    public String fn1(){
        System.out.println("fn1方法");
        return null;
    }

    @RequestMapping("/fn2")
    public String fn2(){
        String s = null;
        System.out.println(s.length());
        System.out.println("fn2方法");
        return null;
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(Throwable e) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "text/html;charset=UTF-8");
        ResponseEntity entity = new ResponseEntity("出错了，原因：" + e, headers, HttpStatus.BAD_REQUEST);
        return entity;
    }

}
