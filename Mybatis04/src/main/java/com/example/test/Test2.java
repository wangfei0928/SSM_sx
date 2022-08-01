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

public class Test2 {

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
    public void testGetBySome() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> all =  mapper.getAll();
        System.out.println(all.size());

//        mapper.deleteById(71);
        Product product = new Product(69,"t003","12","hello");
        mapper.update(product);

        List<Product> all2 =  mapper.getAll();
        System.out.println(all2.size());

//        Product product = mapper.getById(1);
//        System.out.println(product);
//
//        Product product2 = mapper.getById(2);
//        System.out.println(product2);
        //新的SqlSession
//        SqlSession sqlSession2 = sqlSessionFactory.openSession();
//        ProductMapper mapper2 = sqlSession2.getMapper(ProductMapper.class);
//        List<Product> all3 =  mapper2.getAll();
//        System.out.println(all3.size());
    }
}
