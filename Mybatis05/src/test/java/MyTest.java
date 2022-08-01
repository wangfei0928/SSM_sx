import com.example.bean.People;
import com.example.mapper.PeopleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
    public void testInsertMany(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PeopleMapper mapper = sqlSession.getMapper(PeopleMapper.class);
        People people = new People("李逵", "123123", "男");
        People people2 = new People("张飞", "123123", "女");
        People people3 = new People("花木兰", "123123", "男");
        List<People> peopleList = new ArrayList<>();
        peopleList.add(people);
        peopleList.add(people2);
        peopleList.add(people3);
        mapper.insertMany(peopleList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testGetAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PeopleMapper mapper = sqlSession.getMapper(PeopleMapper.class);
        List<People> peopleList = mapper.getAll();
        for (People people : peopleList) {
            System.out.println(people);
        }

        PeopleMapper mapper2 = sqlSession.getMapper(PeopleMapper.class);
        List<People> peopleList2 = mapper2.getAll();
        for (People people : peopleList2) {
            System.out.println(people);
        }

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        PeopleMapper mapper3 = sqlSession2.getMapper(PeopleMapper.class);
        List<People> peopleList3 = mapper3.getAll();
        for (People people : peopleList3) {
            System.out.println(people);
        }
    }
}
