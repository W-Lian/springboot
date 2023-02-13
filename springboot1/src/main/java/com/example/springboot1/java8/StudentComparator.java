package com.example.springboot1.java8;

import com.example.springboot1.dto.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getHeight().compareTo(o2.getHeight());
    }

    public static void main(String[] args) {
        List<Student> sList = new ArrayList<>();
        Student s1 = Student.builder().
                name("tom").
                height("12").
                high("123").
                build();
        Student s2 = Student.builder().
                name("lisi").
                height("13").
                high("124").
                build();
        sList.add(s2);
        sList.add(s1);

        System.out.println(sList);

        //原始的实现方式
//        sList.sort(new StudentComparator());

        //使用lambda表达式实现
        sList.sort(Comparator.comparing(Student::getHeight));

        //jdk stream 实现
//        sList.stream().
//                map(s -> s.getHeight().compareTo(o2.getHeight()));

        System.out.println(sList);
    }
}
