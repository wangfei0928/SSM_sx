package com.example.service;

import com.example.bean.Role;
import com.example.bean.User;

import java.util.List;

public interface IUserService {

    public User getByName(String username);

    public List<Role> getRoleByName(String username);
}
