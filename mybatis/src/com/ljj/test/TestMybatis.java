package com.ljj.test;

import com.ljj.bo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/18 13:47
 * @Description:
 */
public class TestMybatis {

    @Test
    public void findByUserId() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第一个参数是映射文件中namespace(命名空间)+“.”+statement的id,第二个参数是出入sql的参数
        User user = sqlSession.selectOne("com.ljj.mapping.userMapper.findUserById", 1);
        System.out.println(user);
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void findByUserName() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第一个参数是映射文件中namespace(命名空间)+“.”+statement的id,第二个参数是出入sql的参数
        List<User> list = sqlSession.selectList("com.ljj.mapping.userMapper.findUserByUserName", "李");
        for (User obj: list){
            System.out.println(obj);
        }
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void insertUser() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUser_name("赵八");
        user.setUser_pwd("kkk");
        int row = sqlSession.insert("com.ljj.mapping.userMapper.insertUser", user);
        //必须加上事务提交，不然数据不会入库
        sqlSession.commit();
        //获取插入后的主键id值
        int user_id = user.getUser_id();
        System.out.println("row:"+row);
        System.out.println("user_id:"+user_id);

        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void deleteUser() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int row = sqlSession.delete("com.ljj.mapping.userMapper.deleteUserByUserId", 8);
        //必须加上事务提交，不然数据不会入库
        sqlSession.commit();
        System.out.println(row);

        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void updaetUser() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUser_id(7);
        user.setUser_name("hhh");
        user.setUser_pwd("ooo");
        int row = sqlSession.update("com.ljj.mapping.userMapper.updateUser", user);
        //必须加上事务提交，不然数据不会入库
        sqlSession.commit();
        System.out.println(row);

        sqlSession.close();
        inputStream.close();
    }
}
