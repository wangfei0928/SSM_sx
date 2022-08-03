package com.example.service.impl;

import com.example.dao.IDao;
import com.example.dao.impl.MysqlDaoImpl;
import com.example.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ServiceImpl implements IService {

    @Autowired
    private IDao dao;

    @Override
    public void query() {
        dao.query();
    }
}
