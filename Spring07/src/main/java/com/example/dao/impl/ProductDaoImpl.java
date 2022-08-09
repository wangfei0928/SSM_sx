package com.example.dao.impl;

import com.example.bean.Product;
import com.example.dao.IProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl implements IProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Product product) {
        String sql = "insert111 into product(name,price,img) values(?,?,?)";
        jdbcTemplate.update(sql,product.getName(),product.getPrice(),product.getImg());
    }

    @Override
    public List<Product> getAll() {
        String sql = "select* from product";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Product>(Product.class));
    }

    @Override
    public Product getById(Integer id) {
        String sql = "select * from product where id="+id;
//        Map<String,Object> map = jdbcTemplate.queryForMap(sql);//通用
//        String name = jdbcTemplate.queryForObject(sql,String.class);//查出来是一个字段
        RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);//进行映射
        Product product = jdbcTemplate.queryForObject(sql,rowMapper);
        System.out.println(product);
        return product;
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "delete from product where id=?";
        jdbcTemplate.update(sql,id);
    }
}
