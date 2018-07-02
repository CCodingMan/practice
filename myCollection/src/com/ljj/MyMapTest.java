package com.ljj;

import com.ljj.map.MyMap;
import com.ljj.map.MyMap2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ljj
 * @Date: 2018/7/1 15:00
 * @Description:map测试类
 */
public class MyMapTest {
    public static void main(String[] args) {
//        MyMap map = new MyMap();
//        map.put("name", "张三");
//        map.put("age", "20");
//
//        System.out.println(map.get("name"));
//        System.out.println(map.get("age"));
//
//        System.out.println(map.containsKey("name"));

        MyMap2 map = new MyMap2();
        map.put("name", "张三");
        map.put("name", "李四");

        System.out.println(map.get("name"));

    }
}
