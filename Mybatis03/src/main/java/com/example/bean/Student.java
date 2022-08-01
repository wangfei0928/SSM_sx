package com.example.bean;

public class Student {

    private Integer sid;
    private String sname;
    private String gender;
    private Integer age;
    private Integer tid;

    private Teacher teacher;

    public Student() {
    }

    public Student(Integer sid, String sname, String gender, Integer age, Integer tid) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.age = age;
        this.tid = tid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
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

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
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
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", tid=" + tid +
                ", teacher=" + teacher +
                '}';
    }
}
