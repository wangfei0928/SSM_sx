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

public class MyExecute {

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
    public void testInsert1(){
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        productMapper.insertParam("absssss","123","hello.jpg");
//        sqlSession.commit();
//        sqlSession.close();
    }

    @Test
    public void testInsert2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product = new Product("eee","5","abc.jpg");
        System.out.println(product.getId());
        productMapper.insertPro(product);
        System.out.println(product.getId());
    }

    @Test
    public void TestUpdate(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product = new Product(52,"hello","12","hello.jpg");
        productMapper.update(product);
    }

    @Test
    public void deleteById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        productMapper.deleteById(47);
    }
}
