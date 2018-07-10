package com.ljj.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Auther: ljj
 * @Date: 2018/7/9 20:50
 * @Description:
 */
@Component(value = "testAnnotationBO2")
public class TestAnnotationBO2 {
    private String name;

    //可以不添加set方法
//    @Autowired
//    private TestAnnotationBO testAnnotationBO;

    @Resource(name = "testAnnotationBO")
    private TestAnnotationBO testAnnotationBO;

    public TestAnnotationBO2() {
    }

    public TestAnnotationBO2(String name, TestAnnotationBO testAnnotationBO) {
        this.name = name;
        this.testAnnotationBO = testAnnotationBO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestAnnotationBO getTestAnnotationBO() {
        return testAnnotationBO;
    }

    public void setTestAnnotationBO(TestAnnotationBO testAnnotationBO) {
        this.testAnnotationBO = testAnnotationBO;
    }

    @Override
    public String toString() {
        return "TestAnnotationBO2{" +
                "name='" + name + '\'' +
                ", testAnnotationBO=" + testAnnotationBO +
                '}';
    }
}
