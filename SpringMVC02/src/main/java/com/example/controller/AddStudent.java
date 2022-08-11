package com.example.controller;

import com.example.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddStudent {

    @RequestMapping("/addStudent")
//    public ModelAndView addStudent(String sname,Double score){ //有可能报400错误，前端传过来的值，类型不匹配
//        System.out.println(sname);
//        System.out.println(score);
//        return null;
//    }
    public ModelAndView addStudent(Student student,@RequestHeader("user-Agent") String userAgent){ //可以直接传递类
        System.out.println(student.getSname());
        System.out.println(student.getScore());
        System.out.println(userAgent);
        return null;
    }


    @RequestMapping("/getId/{id}/{str}")
    public ModelAndView fn3(@PathVariable Integer id,@PathVariable String str){
        System.out.println(id);
        System.out.println(str);
        return null;
    }

}
