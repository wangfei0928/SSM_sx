package com.example.mapper;

import com.example.bean.Role;
import com.example.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public User getByName(String username);

    public List<Role> getRoleByName(String username);
}
