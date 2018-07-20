package com.ljj.bo;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/19 00:19
 * @Description:用户查询视图类
 */
public class UserQueryVo {
    private List<Integer> ids;
    private UserCustom userCustom;

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
