package com.ljj.bo.map;

import java.util.LinkedList;

/**
 * @Auther: ljj
 * @Date: 2018/7/1 15:01
 * @Description:map简单实现数组+链表
 */
public class MyMap2 {
    //暂时不考虑扩容,map底层结构为数组+链表
    LinkedList[] arr = new LinkedList[20];
    int size;

    public MyMap2() {
    }

    @SuppressWarnings("unchecked")
    public void put(Object key, Object value){
        MyEntry entry = new MyEntry(key,value);
        int hash = key.hashCode();
        hash = hash<0?-hash:hash;
        int a = hash%arr.length;
        if(arr[a] == null){
            LinkedList linkList = new LinkedList();
            linkList.add(entry);
            arr[a] = linkList;
        }else{
            LinkedList list = arr[a];
            for (Object aList : list) {
                MyEntry entry2 = (MyEntry) aList;
                if (entry2.key.equals(key)) {
                    entry2.value = value;
                    return;
                }
            }
            arr[a].add(entry);
        }
    }

    public Object get(Object key){
        int hash = key.hashCode();
        hash = hash<0?-hash:hash;
        int a = hash%arr.length;
        if(arr[a] != null){
            LinkedList list = arr[a];
            for (Object aList : list) {
                MyEntry entry = (MyEntry) aList;
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }
}
