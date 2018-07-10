package com.ljj.dao;

import com.ljj.bo.Student;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/9 04:19
 * @Description:
 */
public interface IStudentDAO {
    boolean save(Student bo);

    boolean delete(String no);

    boolean update(Student bo);

    List<Student> getStudent(Student bo);
}
