package com.ljj.bo;

/**
 * @Auther: ljj
 * @Date: 2018/7/9 15:19
 * @Description:
 */
public class TestBO {
    private String no;
    private String name;

    public TestBO() {
    }

    public TestBO(String no, String name) {
        this.no = no;
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestBO{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
