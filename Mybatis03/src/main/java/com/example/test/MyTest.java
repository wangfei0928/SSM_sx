package com.example.test;

import com.example.bean.Product;
import com.example.mapper.ProductMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {

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
    public void testFindAll() throws IOException {
        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> productList = productMapper.findAll();
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Test
    public void testFindById() throws Exception{

        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product = productMapper.finById(11);
        System.out.println(product);
    }

    @Test
    public void testFindByName() throws Exception{

        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> list = productMapper.findByName("芒果");
        for (Product product : list) {
            System.out.println(product);
        }
    }

    @Test
    public void testFindByNameAndPrice() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> productList = productMapper.findByNameAndPrice("芒果", "123.00");
        for (Product product : productList) {
            System.out.println(product);
        }

    }

    @Test
    public void testFindByOrder() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> img = productMapper.findAllByOrder("price");
        for (Product product : img) {
            System.out.println(product);
        }
    }

    @Test
    public void testGetBySome(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product = new Product("abc","123","hello");
        List<Product> productList = productMapper.getBySome(product);
        for (Product product1 : productList) {
            System.out.println(product1);
        }
    }
}
