package com.example.bean;

import java.util.List;
import java.util.Map;

public class Student {

    private Integer id;
    private String name;
    private String sex;
    private Teacher teacher;
    private List<String> hobby;

    private Integer[] scores;

    private Map<Integer,String>  maps;

    public Student() {
        System.out.println("spring容器创建了");
    }

    public Student(Integer id, String name, String sex) {
        System.out.println("有参构造方法执行了");
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Student(Integer id, String name, String sex, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.teacher = teacher;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer[] getScores() {
        return scores;
    }

    public void setScores(Integer[] scores) {
        this.scores = scores;
    }

    public Map<Integer, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<Integer, String> maps) {
        this.maps = maps;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
