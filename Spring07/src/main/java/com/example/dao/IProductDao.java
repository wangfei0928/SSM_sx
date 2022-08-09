package com.example.dao;

import com.example.bean.Product;

import java.util.List;

public interface IProductDao {

    public void insert(Product product);

    public Product getById(Integer id);

    public List<Product> getAll();

    public void deleteById(Integer id);
}
