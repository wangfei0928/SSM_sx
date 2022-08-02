package com.example.comfig;

import com.example.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.bean")
public class MyConfiguration {

//    @Bean
//    public Student getStudent(){
//        return new Student();
//    }

}
