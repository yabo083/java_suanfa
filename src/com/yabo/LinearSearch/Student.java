package com.yabo.LinearSearch;

import java.util.Objects;

public class Student {


    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && score == student.score && name.equalsIgnoreCase(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, score);
    }

    private String name;
    private int age;
    private int score;

//    @Override
//    public boolean equals(Object E){
//        Student P = (Student) E;
//        if((P.name.equals(name)) && (P.age==age) && (P.score == score) ){
//            return true;
//        }else {
//            return false;
//        }

    }

