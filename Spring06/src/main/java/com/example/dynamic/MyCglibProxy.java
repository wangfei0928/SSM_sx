package com.example.dynamic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyCglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();
    public <T>T getProxy(Class<T> c){
        enhancer.setSuperclass(c);
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        methodProxy.invokeSuper(o,objects);
        System.out.println("提交事务");
        return null;
    }
}
