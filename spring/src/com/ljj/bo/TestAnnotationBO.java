package com.ljj.bo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/9 20:34
 * @Description:
 */
@Component(value = "testAnnotationBO")
public class TestAnnotationBO {
    private String no;
    private String name;

    public TestAnnotationBO() {
    }

    public TestAnnotationBO(String no, String name) {
        this.no = no;
        this.name = name;
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

    @Override
    public String toString() {
        return "TestAnnotationBO{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
