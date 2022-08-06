package com.example.test;

import com.example.service.AdminService;
import com.example.staticproxy.StaticProxy;

public class MyStaticTest {

    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        StaticProxy proxy = new StaticProxy(adminService);
        proxy.getAll();
    }
}
