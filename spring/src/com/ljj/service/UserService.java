package com.ljj.service;

import com.ljj.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: ljj
 * @Date: 2018/7/10 12:42
 * @Description:
 */
public class UserService {
//    @Autowired
    private UserDao userDao;

    public void add(){
        System.out.println("service...");
        userDao.add();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
