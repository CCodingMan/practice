package com.ljj.bo;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: ljj
 * @Date: 2018/7/17 14:28
 * @Description:
 */
public class User {
    private Integer user_id;
    private String user_name;
    private String user_password;
    private Set<Role> setRole = new HashSet<>();

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Set<Role> getSetRole() {
        return setRole;
    }

    public void setSetRole(Set<Role> setRole) {
        this.setRole = setRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", setRole=" + setRole +
                '}';
    }
}
