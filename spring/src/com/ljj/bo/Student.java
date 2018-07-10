package com.ljj.bo;

import java.util.Objects;

/**
 * @Auther: ljj
 * @Date: 2018/7/9 04:15
 * @Description:学生类
 */
public class Student {
    private int id;
    private String no;
    private String name;
    private int age;
    private Teacher teacher;

    public Student() {
    }

    public Student(int id, String no, String name, int age, Teacher teacher) {
        this.id = id;
        this.no = no;
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }
}
