package com.example.service;

import com.example.bean.Role;
import com.example.bean.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByName(String username) {

        return userMapper.getByName(username);
    }

    @Override
    public List<Role> getRoleByName(String username) {
        return userMapper.getRoleByName(username);
    }
}
