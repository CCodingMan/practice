package com.ljj.bo;

/**
 * @Auther: ljj
 * @Date: 2018/7/10 10:52
 * @Description:
 */
public class Book {
    private String name;
    private String no;

    public Book() {
    }

    public Book(String name, String no) {
        this.name = name;
        this.no = no;
    }

    public void add(){
        System.out.println("add.....");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
