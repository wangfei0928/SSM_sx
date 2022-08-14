package com.example.dao;

import com.example.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl implements IProductDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询所有的商品
     * @return list 用list封装Product
     */
    @Override
    public List<Product> getAll() {
        String sql = "select * from product";
        BeanPropertyRowMapper<Product> mapper = BeanPropertyRowMapper.newInstance(Product.class);
        List<Product> productList = jdbcTemplate.query(sql,mapper);
        return productList;
    }

    /**
     * 插入 添加商品
     * @param product
     */
    @Override
    public void insert(Product product) {
        String sql = "insert into product(name,price,img) values(?,?,?)";
        jdbcTemplate.update(sql,product.getName(),product.getPrice(),product.getImg());
    }

    /**
     * 根据id获取product
     * @param id
     * @return
     */
    @Override
    public Product getById(Integer id) {
        String sql = "select * from product where id = ?";
        BeanPropertyRowMapper<Product> mapper = BeanPropertyRowMapper.newInstance(Product.class);
        return jdbcTemplate.queryForObject(sql,mapper,id);
    }

    /**
     * 更新product
     * @param product
     */
    @Override
    public void updateById(Product product) {
        String sql = "update product set name = ?,price = ?,img = ? where id = ?";
        jdbcTemplate.update(sql,product.getName(),product.getPrice(),product.getImg(),product.getId());
    }

    /**
     * 根据id产出产品
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        String sql = "delete from product where id = ?";
        jdbcTemplate.update(sql,id);
    }

    /**
     * 分页查询
     * @param pageNo  当前页数
     * @param pageSize  页数大小
     * @return
     */
    @Override
    public List<Product> getByPage(Integer pageNo,Integer pageSize) {
        String sql = "select * from product limit ?,?";
        BeanPropertyRowMapper<Product> mapper = BeanPropertyRowMapper.newInstance(Product.class);
        List<Product> productList = jdbcTemplate.query(sql,mapper,(pageNo-1)*pageSize,pageSize);
        return productList;
    }

    @Override
    public Integer getTotal() {
        String sql = "select count(*) from product";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
