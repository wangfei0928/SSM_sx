package com.example.bean;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class Student {

    private Integer id;
    private String sname;
    private Double score;

    public Student() {
    }

    public Student(Integer id, String sname, Double score) {
        this.id = id;
        this.sname = sname;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + sname + '\'' +
                ", score=" + score +
                '}';
    }
}
