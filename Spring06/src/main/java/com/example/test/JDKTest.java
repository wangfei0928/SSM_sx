package com.example.test;

import com.example.dynamic.MyJDKProxy;
import com.example.service.IPersonService;
import com.example.service.PersonService;

import java.lang.reflect.Proxy;

public class JDKTest {

    public static void main(String[] args) {

        IPersonService personService = new PersonService();
        ClassLoader classLoader = personService.getClass().getClassLoader();//得到类的加载器
        Class<?>[] interfaces = personService.getClass().getInterfaces();  //得到接口
        IPersonService proxyPersonService = (IPersonService) Proxy.newProxyInstance(classLoader, interfaces, new MyJDKProxy(personService));
        proxyPersonService.getAll();

    }
}
