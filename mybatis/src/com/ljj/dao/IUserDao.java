package com.ljj.dao;

import com.ljj.bo.User;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/18 17:22
 * @Description:
 */
public interface IUserDao {
    int insertUser(User user) throws Exception;

    int deleteUser(int userId) throws Exception;

    int updaetUser(User user) throws Exception;

    User findByUserId(int userId) throws Exception;

    List<User> findByUserName(String userName) throws Exception;
}
