package com.example.dao.impl;

import com.example.bean.People;
import com.example.bean.Product;
import com.example.dao.IPeopleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeopleDaoImpl implements IPeopleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(People people) {
        String sql = "insert into people(name,password,status) values(?,?,?)";
        jdbcTemplate.update(sql,people.getName(),people.getPassword(),people.getStatus());
    }

    @Override
    public List<People> getAll() {
        String sql = "select* from people";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<People>(People.class));
    }

    @Override
    public void update(People people) {
        String sql = "update people set name=? where id=?";
        jdbcTemplate.update(sql,people.getName(),people.getId());
    }
}
