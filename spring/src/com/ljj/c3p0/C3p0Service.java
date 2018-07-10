package com.ljj.c3p0;

/**
 * @Auther: ljj
 * @Date: 2018/7/10 20:06
 * @Description:
 */
public class C3p0Service {
    private C3p0Dao c3p0Dao;

    public void setC3p0Dao(C3p0Dao c3p0Dao) {
        this.c3p0Dao = c3p0Dao;
    }

    public void add(){
        c3p0Dao.add();
    }
}
