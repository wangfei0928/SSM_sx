package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements IMyService{
    @Override
    public void fn1() {
        System.out.println("hello");
    }
}
