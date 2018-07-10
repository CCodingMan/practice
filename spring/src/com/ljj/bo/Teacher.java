package com.ljj.bo;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/9 15:38
 * @Description:
 */
public class Teacher {
    private String no;
    private List<Student> studentList;
    private String name;

    public Teacher() {
    }

    public Teacher(String no, List<Student> studentList, String name) {
        this.no = no;
        this.studentList = studentList;
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "no='" + no + '\'' +
                ", studentList=" + studentList +
                ", name='" + name + '\'' +
                '}';
    }
}
