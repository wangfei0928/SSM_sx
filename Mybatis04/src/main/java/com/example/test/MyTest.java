package com.example.test;

import com.example.bean.Product;
import com.example.mapper.ProductMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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
    public void testGetBySome(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> productList = productMapper.getBySome("", "", "");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        productMapper.update(new Product(35,"ceshi","11",""));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testIdByOne(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> productList = productMapper.idByOfOne("","12","");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Test
    public void testGetByIds() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Integer ids[] = {1, 43, 22};
        List<Product> productList =productMapper.getByIds(ids);
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Test
    public void testGetByNames() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        List<String> names = Arrays.asList("手机","aaa");
        List<Product> productList =productMapper.getByNames(names);
        for (Product product : productList) {
            System.out.println(product);
        }
    }
    @Test
    public void testByMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Map map = new HashMap<>();
        map.put("哈哈","hello");
        List<Product> productList =productMapper.getByMap(map);
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Test
    public void testInsertOne(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product = new Product("test","13","test.jpg");
        productMapper.insertOne(product);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertMany(){
        List<Product> list = new ArrayList<>();
        Product product = new Product("test1","13","test.jpg");
        Product product2 = new Product("test2","13","test.jpg");
        Product product3 = new Product("test3","13","test.jpg");
        list.add(product);
        list.add(product2);
        list.add(product3);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        for (Product product1 : list) {
            productMapper.insertOne(product1); //尽量避免循环调用数据库
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertMany2(){
        List<Product> list = new ArrayList<>();
        Product product = new Product("test1","13","test.jpg");
        Product product2 = new Product("test2","13","test.jpg");
        Product product3 = new Product("test3","13","test.jpg");
        list.add(product);
        list.add(product2);
        list.add(product3);
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        mapper.insertMany(list);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertMany3(){
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);/*一次插入多个*/
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> list = new ArrayList<>();
        Product product = new Product("t10044","13","test.jpg");
        Product product2 = new Product("t0002","13","test.jpg");
        Product product3 = new Product("t003","13","test.jpg");
        list.add(product);
        list.add(product2);//咱们先不看这个，看最普通的
        list.add(product3);

        for (Product product1 : list) {
            mapper.insertOne(product1);
        }

//        sqlSession.commit();
        sqlSession.flushStatements();//
        sqlSession.commit();
        sqlSession.close();
    }



}
