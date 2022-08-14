package com.example.service;

import com.example.bean.Product;
import com.example.dao.IProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductDao productDao;
    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public void insert(Product product) {
        productDao.insert(product);
    }

    @Override
    public Product getById(Integer id) {
        return productDao.getById(id);
    }

    @Override
    public void updateById(Product product) {
        productDao.updateById(product);
    }

    @Override
    public void deleteById(Integer id) {
        productDao.deleteById(id);
    }

    @Override
    public List<Product> getByPage(Integer pageNo, Integer pageSize) {
        return productDao.getByPage(pageNo,pageSize);
    }

    @Override
    public Integer getTotal() {
        return productDao.getTotal();
    }


}
