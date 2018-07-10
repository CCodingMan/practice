package com.ljj.controller;

import com.ljj.bo.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: ljj
 * @Date: 2018/7/9 13:39
 * @Description:
 */
public class TestSpring {

    @Test
    public void testStudent(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContent.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }

    @Test
    public void testAttr() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContent.xml");
        TestBO testBO = (TestBO) context.getBean("testbo");
        System.out.println(testBO.toString());
    }

    @Test
    public void testObjectInject() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContent.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
    }

    @Test
    public void testNameSpaceInject() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContent.xml");
        Teacher teacher = (Teacher) context.getBean("teacher");
        System.out.println(teacher.toString());
    }

    @Test
    public void testComplexAttrInject() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContent.xml");
        TestComplexAttrInject testComplexAttrInject = (TestComplexAttrInject) context.getBean("complexAttrInject");
        System.out.println(testComplexAttrInject.toString());
    }

    @Test
    public void testAnnotationClass() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContent.xml");
        TestAnnotationBO testAnnotationBO = (TestAnnotationBO) context.getBean("testAnnotationBO");
        System.out.println(testAnnotationBO);
    }

    @Test
    public void testAnnotationClass2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContent.xml");
        TestAnnotationBO2 testAnnotationBO2 = (TestAnnotationBO2) context.getBean("testAnnotationBO2");
        System.out.println(testAnnotationBO2);
    }
}
