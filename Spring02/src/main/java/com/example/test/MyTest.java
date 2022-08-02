package com.example.test;

import com.example.bean.Student;
import com.example.comfig.MyConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {

    @Test
    public void test1(){

        AnnotationConfigApplicationContext act = new AnnotationConfigApplicationContext(MyConfiguration.class);
        Student student = act.getBean(Student.class);
        student.setName("aaa");
        System.out.println(student.getName());

    }
}
