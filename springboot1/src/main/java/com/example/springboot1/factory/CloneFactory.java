package com.example.springboot1.factory;

import com.example.springboot1.dto.EnemyPlane;

//浅拷贝
public class CloneFactory {
    static EnemyPlane enemyPlane = new EnemyPlane(200);

    public EnemyPlane getEnemyPlane(int x) throws CloneNotSupportedException {
        EnemyPlane e = enemyPlane.clone();
        e.setX(x);
        return e;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneFactory cf = new CloneFactory();
        EnemyPlane e = cf.getEnemyPlane(100);
    }
}
