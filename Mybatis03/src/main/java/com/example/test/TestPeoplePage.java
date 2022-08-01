package com.example.test;

import com.example.bean.People;
import com.example.mapper.PeopleMapper;
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

public class TestPeoplePage {
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
    public void testPagePeople(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PeopleMapper mapper = sqlSession.getMapper(PeopleMapper.class);
        PageHelper.startPage(1,3);
        List<People> peopleList = mapper.getAll2();
        System.out.println(peopleList);
    }
}
