package com.example.test;

import com.example.bean.Product;
import com.example.controller.ProductController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    @Test
    public void testInsert(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductController productController = context.getBean(ProductController.class);
        Product product = new Product("中午好","11","123.jpg");
        productController.insert(product);
    }

    @Test
    public void testGetById(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductController productController = context.getBean(ProductController.class);
        Product product = productController.getById(1);

    }

    @Test
    public void testGetAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductController productController = context.getBean(ProductController.class);
        List<Product> all = productController.getAll();
        for (Product product : all) {
            System.out.println(product);
        }
    }

    @Test
    public void testDel(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductController productController = context.getBean(ProductController.class);
        productController.deleteById(70);
    }

    @Test
    public void testDosome(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductController productController = context.getBean(ProductController.class);
        productController.doSome();
    }
}

