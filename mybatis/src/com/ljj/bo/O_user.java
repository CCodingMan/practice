package com.ljj.bo;

import java.util.Date;
import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/19 13:08
 * @Description:订单用户类
 */
public class O_user {
    private int id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    private List<O_orders> ordersList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<O_orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<O_orders> ordersList) {
        this.ordersList = ordersList;
    }
}
