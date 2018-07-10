package com.ljj.bo;

import java.util.Objects;

/**
 * @Auther: ljj
 * @Date: 2018/7/9 04:15
 * @Description:学生类
 */
public class Student {
    private String no;
    private String name;
    private int age;
    private Teacher teacher;

    public Student() {
    }

    public Student(String no, String name, int age, Teacher teacher) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.teacher = teacher;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(no, student.no) &&
                Objects.equals(name, student.name) &&
                Objects.equals(teacher, student.teacher);
    }

    @Override
    public int hashCode() {

        return Objects.hash(no, name, age, teacher);
    }

    @Override
    public String toString() {
        return "Student{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }
}
