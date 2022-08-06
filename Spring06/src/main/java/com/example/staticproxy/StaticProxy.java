package com.example.staticproxy;

import com.example.service.AdminService;

public class StaticProxy {

    private AdminService adminService;


    public StaticProxy(AdminService adminService){
        this.adminService = adminService;
    }

    public void getAll(){
        System.out.println("开启事务");
        adminService.getAll();
        System.out.println("关闭事务");
    }

    public void delById(){
        System.out.println("开启事务");
        adminService.delById();
        System.out.println("关闭事务");
    }

    public void update(){
        System.out.println("开启事务");
        adminService.update();
        System.out.println("关闭事务");
    }

}
