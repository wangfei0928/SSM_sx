package com.example.service;

import com.example.bean.Product;

import java.util.List;

public interface IProductService {

    public List<Product> getAll();

    public void insert(Product product);

    public Product getById(Integer id);

    public void updateById(Product product);

    public void deleteById(Integer id);

    public List<Product> getByPage(Integer pageNo,Integer pageSize);

    public Integer getTotal();


}
