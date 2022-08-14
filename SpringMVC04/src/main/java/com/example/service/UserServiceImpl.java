package com.example.service;

import com.example.bean.User;
import com.example.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserDao userDao;
    @Override
    public User login(String uname, String password) {
        return userDao.login(uname, password);
    }
}
