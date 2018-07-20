package com.ljj.test;

import com.ljj.bo.User;
import com.ljj.bo.UserCustom;
import com.ljj.bo.UserQueryVo;
import com.ljj.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: ljj
 * @Date: 2018/7/18 21:11
 * @Description:
 */
public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void insertUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUser_name("qqq");
        user.setUser_pwd("ddd");

        //创建接口实现类代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int userId = userMapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();

        System.out.println("userId:"+userId);
    }

    @Test
    public void deleteUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建接口实现类代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int row = userMapper.deleteUserByUserId(10);
        sqlSession.commit();
        sqlSession.close();

        System.out.println("deleteRow:"+row);
    }

    @Test
    public void updaetUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUser_id(10);
        user.setUser_name("bbb");
        user.setUser_pwd("ppp");
        //创建接口实现类代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int row = userMapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();

        System.out.println("updateRow:"+row);
    }

    @Test
    public void findByUserId() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建接口实现类代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        sqlSession.close();
        System.out.println(user);
    }

    @Test
    public void findByUserName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建接口实现类代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findUserByUserName("李");
        sqlSession.close();
        for (User obj: list){
            System.out.println(obj);
        }
    }

    @Test
    public void findUserList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建接口实现类代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUser_name("李");
//        userCustom.setUser_pwd("123");
        userQueryVo.setUserCustom(userCustom);
        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(3);
        userQueryVo.setIds(ids);
        List<UserCustom> list = userMapper.findUserList(userQueryVo);
        sqlSession.close();
        for (UserCustom obj: list){
            System.out.println(obj);
        }
    }

    @Test
    public void findUserCount() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建接口实现类代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUser_name("李");
        userQueryVo.setUserCustom(userCustom);
        int count = userMapper.findUserCount(userQueryVo);
        sqlSession.close();
        System.out.println("count:"+count);
    }

    @Test
    public void findUserResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建接口实现类代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUser_name("李");
        userQueryVo.setUserCustom(userCustom);
        List<User> list = userMapper.findUserResultMap(userQueryVo);
        sqlSession.close();
        for (User obj: list){
            System.out.println(obj);
        }
    }
}