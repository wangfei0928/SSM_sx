package com.example.test;

import com.example.bean.People;
import com.example.bean.Product;
import com.example.mapper.ProductMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PageTest {

    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        // 通过流加载核心配置文件   还会读取映射配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 获取SqlSessionFactory工厂对象
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void TestGetAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        PageHelper.startPage(3,4);
        List<Product> productList = productMapper.findAll();
        System.out.println(productList.size());
        Page<Product> pageList = (Page<Product>) productList;
        System.out.println("总条数是："+pageList.getTotal());
        System.out.println("总页数是"+pageList.getPages());
        System.out.println("页面大小是"+pageList.getPageSize());
    }
}
