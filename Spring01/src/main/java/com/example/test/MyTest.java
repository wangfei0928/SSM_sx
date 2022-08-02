package com.example.test;

import com.example.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test1(){

        //得到了ApplicationContext springing用的上下文
        //spring容器 spring中的一个缓存 单例池
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //getBean 从spring容器池中获取到我们的对象
        Student stu = (Student) context.getBean("studentFactory");
        System.out.println(stu.hashCode());
        Student stu2 = (Student) context.getBean("studentFactory");
        System.out.println(stu2.hashCode());

        System.out.println(stu.getName());

        Student student = (Student) context.getBean("student");
        System.out.println(student);
        System.out.println(stu.getHobby());
        System.out.println(stu.getMaps());
        System.out.println(stu.getScores().toString());

        System.out.println(stu.getTeacher().getName());
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //getBean 从spring容器池中获取到我们的对象
        Student stu = (Student) context.getBean("stu2");
        System.out.println(stu);
    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //getBean 从spring容器池中获取到我们的对象
        Student stu = (Student) context.getBean("stu3");
        System.out.println(stu);
    }

    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //getBean 从spring容器池中获取到我们的对象
        Student stu = (Student) context.getBean("stu4");
        System.out.println(stu);
    }
}
