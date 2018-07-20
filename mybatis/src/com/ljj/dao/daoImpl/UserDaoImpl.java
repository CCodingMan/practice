package com.ljj.dao.daoImpl;

import com.ljj.bo.User;
import com.ljj.dao.IUserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/18 18:37
 * @Description:
 */
public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public int insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int row = sqlSession.insert("com.ljj.mapping.userMapper.insertUser", user);
        sqlSession.commit();
        int userId = user.getUser_id();
        sqlSession.close();

        return userId;
    }

    @Override
    public int deleteUser(int userId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int row = sqlSession.delete("com.ljj.mapping.userMapper.deleteUserByUserId", userId);
        sqlSession.commit();
        sqlSession.close();

        return row;
    }

    @Override
    public int updaetUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int row = sqlSession.update("com.ljj.mapping.userMapper.updateUser", user);
        sqlSession.commit();
        sqlSession.close();

        return row;
    }

    @Override
    public User findByUserId(int userId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        return sqlSession.selectOne("com.ljj.mapping.userMapper.findUserById", userId);
    }

    @Override
    public List<User> findByUserName(String userName) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        return sqlSession.selectList("com.ljj.mapping.userMapper.findUserByUserName", userName);
    }
}
