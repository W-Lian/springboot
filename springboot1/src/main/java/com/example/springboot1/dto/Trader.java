package com.example.springboot1.dto;


import lombok.Data;

@Data
public class Trader {

    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
