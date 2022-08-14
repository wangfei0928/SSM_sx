package com.example.dao;

import com.example.bean.User;

public interface IUserDao {

    public User login(String uname,String password);
}
