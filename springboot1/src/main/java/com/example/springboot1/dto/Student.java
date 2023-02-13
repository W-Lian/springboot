package com.example.springboot1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {

    private  String name;
    private  Integer age;
    private  String hobby;
    private String height;
    private String high;

    public Student(){};

    public Student(String name, Integer age, String hobby, String height, String high) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.height = height;
        this.high = high;
    }
}
