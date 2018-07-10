package com.ljj.dao;

import com.ljj.bo.Student;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;
import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/10 15:51
 * @Description:
 */
public class TestJdbcTemplate {
    @Test
    public void add(){
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //新建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //调用jdbcTemplate对象方法实现操作
        String sql = "insert into Student (name,age) values (?,?)";
        int row = jdbcTemplate.update(sql, "张三", 10);
        System.out.println(row);

    }

    @Test
    public void update(){
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //新建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //调用jdbcTemplate对象方法实现操作
        String sql = "update Student set name=?,age=? where id=?";
        int row = jdbcTemplate.update(sql, "李四", 20, 1);
        System.out.println(row);

    }

    @Test
    public void delete(){
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //新建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //调用jdbcTemplate对象方法实现操作
        String sql = "delete from Student where id=?";
        int row = jdbcTemplate.update(sql, 1);
        System.out.println(row);

    }

    @Test
    public void count(){
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //新建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //调用jdbcTemplate对象方法实现操作
        String sql = "select count(*) from Student";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);

    }

    //jdbc方式获取对象
    @Test
    public void testJDBC(){
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
            //sql语句
            String sql = "select * from Student where id = ?";
            //预编译sql
            psmt = conn.prepareStatement(sql);
            //设置参数
            psmt.setString(1,"2");
            //执行sql
            rs = psmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);

                System.out.println(student.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                psmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void getObject(){
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //新建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //调用jdbcTemplate对象方法实现操作
        String sql = "select * from Student where id = ?";
        Student student = jdbcTemplate.queryForObject(sql, new MyRowMapper(), 2);
        System.out.println(student);
    }

    class MyRowMapper implements RowMapper<Student>{

        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setAge(age);

            return student;
        }
    }

    @Test
    public void getList(){
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //新建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //调用jdbcTemplate对象方法实现操作
        String sql = "select * from Student where id > ?";
        List<Student> studentList = jdbcTemplate.query(sql, new MyRowMapper(), 2);
        for(Student student : studentList){
            System.out.println(student);
        }
    }

}
