package com.example.bean;

public class People {
    private int id;
    private String name;
    private String pwd;
    private String sex;

    public People() {
    }

    public People(String name, String pwd, String sex) {
        this.name = name;
        this.pwd = pwd;
        this.sex = sex;
    }

    public People(int id, String name, String pwd, String sex) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String password) {
        this.pwd = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
