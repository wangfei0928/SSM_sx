package com.example.dao;

import com.example.bean.People;

import java.util.List;

public interface IPeopleDao {

    public void insert(People people);

    public List<People> getAll();

    public void update(People people);
}
