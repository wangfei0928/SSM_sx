package com.example.service;

public class PersonService implements IPersonService{

    public void getAll(){
        System.out.println("我是person的getAll（）方法");
    }


    public void delById(){
        System.out.println("我是person的del方法");
    }

    public void update(){
        System.out.println("我是person的update方法");
    }
}
