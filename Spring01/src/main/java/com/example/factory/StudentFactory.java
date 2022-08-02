package com.example.factory;

import com.example.bean.Student;

public class StudentFactory {

    public static Student creatStu(){
        return new Student();
    }
}
