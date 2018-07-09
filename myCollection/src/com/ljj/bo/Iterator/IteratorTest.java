package com.ljj.bo.Iterator;

import com.ljj.bo.arraylist.MyArrayList;

import java.util.Iterator;

/**
 * @Auther: ljj
 * @Date: 2018/7/4 21:47
 * @Description:迭代器测试
 */
public class IteratorTest {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        Iterator itr = list.iterator();
        System.out.println(itr.next());
        System.out.println(itr.next());
        System.out.println(itr.next());
        if (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
