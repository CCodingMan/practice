package com.ljj.c3p0;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Auther: ljj
 * @Date: 2018/7/10 20:07
 * @Description:
 */
public class C3p0Dao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(){
        String sql = "insert into Student (name,age) values(?,?)";
        int row = jdbcTemplate.update(sql, "黑七", 27);
        System.out.println(row);
    }

}
