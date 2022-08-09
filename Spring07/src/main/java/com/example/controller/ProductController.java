package com.example.controller;

import com.example.bean.People;
import com.example.bean.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;
    public void insert(Product product){
        productService.insert(product);
    }

    public Product getById(Integer id){
       return productService.getById(id);
    }

    public List<Product> getAll(){
        return productService.getAll();
    }

    public void deleteById(Integer id){
        productService.deleteById(id);
    }

    public void doSome(){
        productService.doSome(new Product("111","11","11.jpg"),new People(6,"李逵"));
    }
}
