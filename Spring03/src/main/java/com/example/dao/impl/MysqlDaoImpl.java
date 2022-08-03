package com.example.dao.impl;

import com.example.dao.IDao;
import org.springframework.stereotype.Repository;

@Repository
public class MysqlDaoImpl implements IDao {
    @Override
    public void query() {
        System.out.println("我是dao的query");
    }
}
