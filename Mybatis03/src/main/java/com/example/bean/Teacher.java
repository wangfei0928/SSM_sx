package com.example.bean;

import com.example.mapper.StudentMapper;

import java.util.List;

public class Teacher {

    private Integer tid;
    private String tname;
    private String gender;
    private Integer age;

    private List<Student> student;

    public Teacher() {
    }

    public Teacher(Integer tid, String tname, String gender, Integer age) {
        this.tid = tid;
        this.tname = tname;
        this.gender = gender;
        this.age = age;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", student=" + student +
                '}';
    }
}
