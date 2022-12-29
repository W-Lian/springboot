package com.example.springboot1.dto;

import lombok.Data;

@Data
public class Bullet implements Cloneable{
    private String boom;

    @Override
    public Bullet clone() throws CloneNotSupportedException {
        Bullet bullet = (Bullet) super.clone();
        return bullet;
    }
}
