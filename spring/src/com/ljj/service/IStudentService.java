package com.ljj.service;

import com.ljj.bo.Student;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/9 04:25
 * @Description:
 */
public interface IStudentService {
    boolean save(Student bo);

    boolean delete(String no);

    boolean update(Student bo);

    List<Student> getStudent(Student bo);
}
