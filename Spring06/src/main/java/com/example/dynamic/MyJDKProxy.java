package com.example.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyJDKProxy implements InvocationHandler {

    private  Object target;

    public MyJDKProxy(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        System.out.println("Logging: The method "+name+"begins with"+ Arrays.toString(args));
        Object result = method.invoke(target, args);
        System.out.println("Logging: The method "+name+"returns"+ result);
        return result;
    }
}
