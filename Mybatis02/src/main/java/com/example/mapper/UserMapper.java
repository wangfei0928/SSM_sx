package com.example.mapper;

import com.example.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public List<User> getAll();

    public User getById(int id);

    public void insertOne(@Param("uname") String uname, @Param("password")String password, @Param("status")Integer status);

    public void deleteById(Integer id);

    public void update(@Param("uname") String uname, @Param("password")String password, @Param("status")Integer status,@Param("id")Integer id);
}
