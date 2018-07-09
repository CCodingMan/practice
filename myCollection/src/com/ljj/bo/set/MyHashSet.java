package com.ljj.bo.set;

import java.util.HashMap;

/**
 * @Auther: ljj
 * @Date: 2018/7/3 21:59
 * @Description:简单实现HashSet
 */
public class MyHashSet {
    HashMap map;
    private static final Object PERSENT = new Object();

    public MyHashSet() {
        map = new HashMap();
    }

    public void add(Object o) {
        //noinspection unchecked
        map.put(o, PERSENT);
    }

    public int size(){
        return map.size();
    }
}
