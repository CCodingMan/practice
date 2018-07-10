package com.ljj.dao.daoImpl;

import com.ljj.bo.Student;
import com.ljj.dao.IStudentDAO;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/9 04:24
 * @Description:
 */
public class StudentDAOImpl implements IStudentDAO {
    @Override
    public boolean save(Student bo) {
        return false;
    }

    @Override
    public boolean delete(String no) {
        return false;
    }

    @Override
    public boolean update(Student bo) {
        return false;
    }

    @Override
    public List<Student> getStudent(Student bo) {
        return null;
    }
}
