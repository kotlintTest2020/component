package com.liangjz.test.test.test;

public class Person1 {
    public void Person1(String name,int age){
        this.name = name;
        this.age = age;
    }
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
