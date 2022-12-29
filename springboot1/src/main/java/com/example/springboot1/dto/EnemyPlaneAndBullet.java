package com.example.springboot1.dto;

import lombok.Data;

@Data
public class EnemyPlaneAndBullet implements Cloneable{

    private int x;
    private int y;
    private Bullet bullet;

    public EnemyPlaneAndBullet(int x){
        this.x = x;
    }

    void fly(){
        y++;
    }

    @Override
    public EnemyPlaneAndBullet clone() throws CloneNotSupportedException {
        EnemyPlaneAndBullet clone = (EnemyPlaneAndBullet) super.clone();
        clone.setBullet(bullet.clone());
        return clone;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        EnemyPlaneAndBullet e = new EnemyPlaneAndBullet(100);
        Bullet b = new Bullet();
        b.setBoom("100伤害");
        e.setBullet(b);
        System.out.println(e);

        EnemyPlaneAndBullet cloneE = e.clone();
        cloneE.getBullet().setBoom("1000伤害");
        System.out.println(cloneE);
    }

}
