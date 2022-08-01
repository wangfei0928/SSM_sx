package com.example.bean;

import java.util.List;

public class People {
    private Integer id;
    private String name;
    private String password;
    private Integer status;

    private List<Car> clist;
    public People() {
    }

    public People(Integer id, String name, String password, Integer status) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.status = status;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Car> getClist() {
        return clist;
    }

    public void setClist(List<Car> clist) {
        this.clist = clist;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", clist=" + clist +
                '}';
    }
}
