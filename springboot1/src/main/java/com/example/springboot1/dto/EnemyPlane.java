package com.example.springboot1.dto;

import lombok.Data;

@Data
public class EnemyPlane implements Cloneable{

    private int x;
    private int y;

    public EnemyPlane(int x){
        this.x = x;
    }

    void fly(){
        y++;
    }

    @Override
    public EnemyPlane clone() throws CloneNotSupportedException {
        EnemyPlane clone = (EnemyPlane) super.clone();
        return clone;
    }

}
