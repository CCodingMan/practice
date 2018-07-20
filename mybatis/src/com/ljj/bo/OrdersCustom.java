package com.ljj.bo;

/**
 * @Auther: ljj
 * @Date: 2018/7/19 13:17
 * @Description:订单扩展类
 */
public class OrdersCustom extends O_orders {
    private String userName;
    private String sex;
    private String address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
