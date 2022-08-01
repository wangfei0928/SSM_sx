package com.example.test;

import com.example.bean.Student;
import com.example.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.InputStream;
import java.util.List;


public class MyTest {

    public static void main(String[] args) throws Exception {

        //定义mybatis核心配置文件的位置
        String resource = "mybatis-config.xml";
        // 通过流加载核心配置文件   还会读取映射配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行sql
        User user = sqlSession.selectOne("org.abc.selectById",5);
        System.out.println(user);
        System.out.println("-----------");
        List<User> userList = sqlSession.selectList("org.abc.findAll");
        for (User user1 : userList) {
            System.out.println(user1);
        }
        // 释放资源

        System.out.println("-----------");

        // 通过流加载核心配置文件   还会读取映射配置文件
        InputStream inputStream2 = Resources.getResourceAsStream(resource);
        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory2 = new SqlSessionFactoryBuilder().build(inputStream2);
        // 获取SqlSession会话对象
        SqlSession sqlSession2 = sqlSessionFactory2.openSession();
        List<Student> studentList = sqlSession2.selectList("org.stu.findAll");
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
        System.out.println("-----------");
        Object o = sqlSession2.selectOne("org.stu.selectById", 1);
        System.out.println(o);

    }

}
