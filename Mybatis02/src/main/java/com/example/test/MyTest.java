package com.example.test;

import com.example.bean.Student;
import com.example.bean.User;
import com.example.mapper.StudentMapper;
import com.example.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {

    public static void main(String[] args) throws IOException {
        //定义mybatis核心配置文件的位置
        String resource = "mybatis-config.xml";
        // 通过流加载核心配置文件   还会读取映射配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getAll();
        for (User user : userList) {
            System.out.println(user);
        }

        System.out.println("-------------------------");
        User user = mapper.getById(4);
        System.out.println(user);

        /*StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.getAll();
        for (Student student : studentList) {
            System.out.println(student);
        }*/
        System.out.println("-------------------------");

//        mapper.insertOne("张飞","123123",1);
        for (User newuser : userList) {
            System.out.println(newuser);
        }
        System.out.println("-------------------------");
        mapper.deleteById(8);
        for (User newuser2 : userList) {
            System.out.println(newuser2);
        }
        System.out.println("-------------------------");
        mapper.update("宋江","123321",0,7);
        for (User newuser3 : userList) {
            System.out.println(newuser3);
        }
    }
}
