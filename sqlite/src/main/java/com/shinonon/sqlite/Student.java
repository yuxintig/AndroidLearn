package com.shinonon.sqlite;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String classmate;
    private int age;

    public Student() {
    }
    public Student(String name,String classmate, int age){

        this.name = name;
        this.classmate = classmate;
        this.age = age;
    }

    public Student(int id, String name, String classmate, int age) {
        this.id = id;
        this.name = name;
        this.classmate = classmate;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassmate() {
        return classmate;
    }

    public void setClassmate(String classmate) {
        this.classmate = classmate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
