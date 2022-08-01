package com.example.bean;

import java.util.List;

public class Car {
    private Integer carid;
    private String name;
    private String color;
    private Integer pid;

    private People people;
    public Car() {
    }

    public Car(Integer carid, String name, String color, Integer pid) {
        this.carid = carid;
        this.name = name;
        this.color = color;
        this.pid = pid;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carid=" + carid +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", pid=" + pid +
                '}';
    }
}
