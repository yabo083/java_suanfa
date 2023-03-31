package com.yabo.Sort;

import com.yabo.Array.Array;

public class Student implements Comparable<Student> {

    private String name;
    private int age;
    private int score;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }



    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student another) {
        return another.score - this.score;
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("Alice", 100, 100));
        arr.addLast(new Student("Bob", 99, 99));
        arr.addLast(new Student("Charlie", 98, 98));
        System.out.println(arr);

    }
}
