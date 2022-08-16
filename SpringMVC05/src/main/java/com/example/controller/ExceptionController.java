package com.example.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public ResponseEntity<String> handleException(Throwable e) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "text/html;charset=UTF-8");
        ResponseEntity entity = new ResponseEntity("出错了，原因：" + e, headers, HttpStatus.BAD_REQUEST);
        return entity;
    }
}
