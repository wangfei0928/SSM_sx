package com.example.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;

public class MySessionListener extends SessionListenerAdapter {

    @Override
    public void onStart(Session session) {
        System.out.println("Session[{}] 创建"+session.getId());
    }

    @Override
    public void onStop(Session session) {
        System.out.println("Session[{}] 已停止"+ session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        System.out.println("Session[{}] 已停止"+session.getId());
    }
}
