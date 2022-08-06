package com.example.test;

import com.example.dynamic.MyCglibProxy;
import com.example.service.AdminService;

public class CglibTest {
    public static void main(String[] args) {
        MyCglibProxy cglibProxy = new MyCglibProxy();
        AdminService adminService = cglibProxy.getProxy(AdminService.class);
        adminService.update();
    }
}
