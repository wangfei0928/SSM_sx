package com.example.service.impl;

import com.example.bean.People;
import com.example.bean.Product;
import com.example.dao.IPeopleDao;
import com.example.dao.IProductDao;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Autowired
    private IPeopleDao peopleDao;
    @Override
    public void insert(Product product) {
        productDao.insert(product);
    }

    @Override
    public Product getById(Integer id) {
        return productDao.getById(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public void deleteById(Integer id) {
        productDao.deleteById(id);
    }

    public void doSome(Product product, People people){
        productDao.insert(product);
        peopleDao.update(people);

    }
}
