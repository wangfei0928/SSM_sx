package com.example.mapper;

import com.example.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductMapper {

    public List<Product> getBySome(@Param("name")String name,@Param("price") String price,@Param("img") String img);

    public void update(Product product);

    public List<Product> idByOfOne(@Param("name")String name,@Param("price") String price,@Param("img") String img);

    public List<Product> getByIds(@Param("ids") Integer [] ids);

    public List<Product> getByNames(@Param("names") List<String> names);

    public List<Product> getByMap(@Param("maps") Map<String,String> map);

    public void insertOne(Product product);

    public void insertMany(@Param("plist") List<Product> list);

    public List<Product> getAll();

    public Product getById(Integer id);

    public void deleteById(Integer id);
}
