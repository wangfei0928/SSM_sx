package com.example.dao;

import com.example.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements IUserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据 uname password查询用户 实现登录操作
     * @param uname
     * @param password
     * @return   user  若查到则返回user
     */
    @Override
    public User login(String uname, String password) {

        String sql = "select * from user where uname = ? and password = ?";
        BeanPropertyRowMapper<User> mapper = BeanPropertyRowMapper.newInstance(User.class);
        User user = jdbcTemplate.queryForObject(sql, mapper, uname, password);
        return user;
    }
}
