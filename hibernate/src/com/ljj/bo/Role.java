package com.ljj.bo;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: ljj
 * @Date: 2018/7/17 14:28
 * @Description:
 */
public class Role {
    private Integer role_id;
    private String role_name;
    private String role_memo;
    private Set<User> setUser = new HashSet<>();

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_memo() {
        return role_memo;
    }

    public void setRole_memo(String role_memo) {
        this.role_memo = role_memo;
    }

    public Set<User> getSetUser() {
        return setUser;
    }

    public void setSetUser(Set<User> setUser) {
        this.setUser = setUser;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", role_memo='" + role_memo + '\'' +
                ", setUser=" + setUser +
                '}';
    }
}
