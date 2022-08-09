package com.example.service;

import com.example.bean.People;
import com.example.bean.Product;

import java.util.List;

public interface IProductService {

    public void insert(Product product);

    public Product getById(Integer id);

    public List<Product> getAll();

    public void deleteById(Integer id);

    public void doSome(Product product,People people);
}
