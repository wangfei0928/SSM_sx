package com.example.controller;


import com.example.bean.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AjaxController {

    @RequestMapping(value = "/getS",produces = "text/html;charset=utf-8")
    @ResponseBody   //指定是ajax的请求，不指定的话就正常走springmvc的视图解析器
    public String ajax01(){
        String s = "你好 ajax";
        return s;
    }

//    @RequestMapping(value = "/getJ", produces = "text/html;charset=utf-8")
//    @ResponseBody   //指定是ajax的请求，不指定的话就正常走springmvc的视图解析器
//    public String json(){
//        Student student = new Student(1,"张三");
//        String jsonStr = JSON.toJSONString(student);
//        return jsonStr;
//    }

    @RequestMapping(value = "/getL")
    @ResponseBody   //指定是ajax的请求，不指定的话就正常走springmvc的视图解析器
    public List<Student> listJson() throws JsonProcessingException {
        Student student = new Student(1,"张三");
        Student student1 = new Student(2,"李四");
        Student student2 = new Student(3,"王五");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
//        String jsonStr = JSON.toJSONString(studentList);
//        ObjectMapper mapper = new ObjectMapper();
//        String s = mapper.writeValueAsString(studentList);
        return studentList;
    }

    @RequestMapping("/getMap")
    @ResponseBody
    public Map<String,Object> ajax04(){
        Map<String,Object> map = new HashMap<>();
        map.put("id","66");
        map.put("name","赵六");
        return map;
    }

    @RequestMapping("/getMaps")
    @ResponseBody
    public List<Map<String, Object>> ajax05(){
        List<Map<String,Object>> mapsList = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("id","66");
        map.put("name","赵六");
        Map<String,Object> map2 = new HashMap<>();
        map.put("id2","666");
        map.put("name2","张飞");
        mapsList.add(map);
        mapsList.add(map2);
        return mapsList;
    }

}
