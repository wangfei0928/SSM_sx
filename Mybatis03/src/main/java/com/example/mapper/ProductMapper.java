package com.example.mapper;

import com.example.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.security.KeyStore;
import java.util.List;

public interface ProductMapper {

    public List<Product> findAll();

    public Product finById(Integer id);

    public List<Product> findByName(String name);

    public List<Product> findByNameAndPrice(@Param("name") String name, @Param("price") String price);

    public List<Product> findAllByOrder(String order);

    public List<Product> getBySome(Product product);

    public void insertParam(@Param("name")String name,@Param("price") String price,@Param("img") String img);

    public void insertPro(Product product);

    public void update(Product product);

    public void deleteById(Integer id);
}
