package com.example.proxy;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyProxy {

    public void per(){
        System.out.println("我是前置方法，开启事务");
    }

    public void after(){
        System.out.println("我是后置通知，提交事务");
    }

    public void afterRe(){
        System.out.println("没有异常 会执行");
    }

    public void exception(){
        System.out.println("出现异常！");
    }

    //环绕通知
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知开始");
        joinPoint.proceed();//详单与调用我们的业务方法
        System.out.println("环绕通知结束");
    }
}
