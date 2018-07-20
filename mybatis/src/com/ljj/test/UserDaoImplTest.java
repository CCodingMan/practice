package com.ljj.test;

import com.ljj.bo.User;
import com.ljj.dao.daoImpl.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/18 19:22
 * @Description:
 */
public class UserDaoImplTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setUser_name("yyy");
        user.setUser_pwd("uuu");
        UserDaoImpl userDao = new UserDaoImpl(sqlSessionFactory);
        int userId = userDao.insertUser(user);
        System.out.println("userId:"+userId);
    }

    @Test
    public void deleteUser() {
        UserDaoImpl userDao = new UserDaoImpl(sqlSessionFactory);
        int row = userDao.deleteUser(9);
        System.out.println("deleteRow:"+row);
    }

    @Test
    public void updaetUser() {
        UserDaoImpl userDao = new UserDaoImpl(sqlSessionFactory);
        User user = new User();
        user.setUser_id(9);
        user.setUser_name("zzz");
        user.setUser_pwd("ttt");
        int row = userDao.updaetUser(user);
        System.out.println("updateRow:"+row);
    }

    @Test
    public void findByUserId() {
        UserDaoImpl userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findByUserId(9);
        System.out.println(user);
    }

    @Test
    public void findByUserName() {
        UserDaoImpl userDao = new UserDaoImpl(sqlSessionFactory);
        List<User> list = userDao.findByUserName("李");
        for (User obj: list){
            System.out.println(obj);
        }
    }
}