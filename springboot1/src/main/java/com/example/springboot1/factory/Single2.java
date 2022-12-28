package com.example.springboot1.factory;

import com.example.springboot1.dto.Student;

//懒汉（线程安全版）
public class Single2 {

    //volatile对静态变量的修饰能保证变量值在各线程访问是的同步性、唯一性
    volatile static Student s;

    private Student getNewInstance() {
        //外层控制多个对象进入，不需要因排队造成堵塞
        if (s == null) {
            //内部控制单个对象的建立，其他则直接返回
            synchronized (Single2.class) {
                if (s == null) {
                    s = new Student();
                }
            }
        }
        return s;
    }


}
