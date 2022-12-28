package com.example.springboot1.factory;

import com.example.springboot1.dto.Student;

//饿汉
public class Single {

    static Student s = new Student();

    private Student getNewInstance() {
        return s;
    }


}
