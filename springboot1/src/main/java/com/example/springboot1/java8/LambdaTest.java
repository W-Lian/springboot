package com.example.springboot1.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaTest {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("");
        Predicate<String> nonEmptyStringPredicate = (String s)-> !s.isEmpty();
        List<String> nonEmpty=filter(stringList, nonEmptyStringPredicate);
        System.out.println(nonEmpty);
    }


    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results=new ArrayList<>();
        for(T s: list){
            if(p.test(s)){
                results.add(s);
            }
        }
        return results;
    }
}
