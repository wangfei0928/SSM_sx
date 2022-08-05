package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class AdminService {

    public void getAll(){
        System.out.println("我是admin的getAll（）方法");
    }


    public void delById(){
//        System.out.println(5/0);
        System.out.println("我是admin的del方法");
    }

    public void update(){
        System.out.println("我是admin的update方法");
    }
}
