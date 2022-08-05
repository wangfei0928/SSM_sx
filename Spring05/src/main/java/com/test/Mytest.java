package com.test;

import com.example.service.AdminService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminService adminService = (AdminService) context.getBean("adminService");
//        adminService.getAll();
        adminService.delById();
//        adminService.update();

//        PersonService personService = context.getBean(PersonService.class);
//        personService.delById();
    }
}
