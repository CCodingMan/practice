package com.ljj.mapper;

import com.ljj.bo.User;
import com.ljj.bo.UserCustom;
import com.ljj.bo.UserQueryVo;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/18 19:55
 * @Description:
 */
public interface UserMapper {
    int insertUser(User user) throws Exception;

    int deleteUserByUserId(int userId) throws Exception;

    int updateUser(User user) throws Exception;

    User findUserById(int userId) throws Exception;

    List<User> findUserByUserName(String userName) throws Exception;

    List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

    List<User> findUserResultMap(UserQueryVo userQueryVo) throws Exception;

    int findUserCount(UserQueryVo userQueryVo) throws Exception;

}
