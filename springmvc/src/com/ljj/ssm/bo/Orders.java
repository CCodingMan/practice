package com.ljj.ssm.bo;

import java.util.Date;
import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/19 13:12
 * @Description:订单类
 */
public class Orders {
    private int id;
    private int userId;
    private String number;
    private Date createTime;
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
