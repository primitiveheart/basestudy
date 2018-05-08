package com.vo;

/**
 * Created by admin on 2018/5/8.
 */
public class Student {
    private String num;
    private String name;
    private String description;

    public Student() {
    }

    public Student(String num, String name, String description) {
        this.num = num;
        this.name = name;
        this.description = description;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Student{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
