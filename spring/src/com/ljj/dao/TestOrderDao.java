package com.ljj.dao;

import com.ljj.bo.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Auther: ljj
 * @Date: 2018/7/11 00:01
 * @Description:
 */
public class TestOrderDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void lessMoney(int money, String userName){
        String sql = "update account set salary=salary-? where username=?";
        int row = jdbcTemplate.update(sql, money, userName);
        System.out.println(row > 0 ? "账户减钱成功" : "账户减钱失败");
    }

    public void moreMoney(int money, String userName){
        String sql = "update account set salary=salary+? where username=?";
        int row = jdbcTemplate.update(sql, money, userName);
        System.out.println(row > 0 ? "账户加钱成功" : "账户加钱失败");
    }

    class MyRowMapper implements RowMapper<Account> {

        @Override
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String userName = resultSet.getString("username");
            int salary = resultSet.getInt("salary");

            Account account = new Account();
            account.setId(id);
            account.setUserName(userName);
            account.setSalary(salary);

            return account;
        }
    }
}
