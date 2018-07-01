package com.ljj.map;

/**
 * @Auther: ljj
 * @Date: 2018/7/1 15:01
 * @Description:map简单实现
 */
public class MyMap {
    //暂时不考虑扩容
    MyEntry[] arr = new MyEntry[20];
    int size;

    public MyMap() {
    }

    public void put(Object key, Object value){
        MyEntry entry = new MyEntry(key,value);
        for(int i=0; i<size; i++){
            if(arr[i].key.equals(key)){
                arr[i].value = value;
                return;
            }
        }

        arr[size++] = entry;
    }

    public Object get(Object key){
        for(int i=0; i<size; i++){
            if(arr[i].key.equals(key)){
                return arr[i].value;
            }
        }
        return null;
    }

    public int size(){
        return size;
    }

    public boolean containsKey(Object key){
        for(int i=0; i<size; i++){
            if(arr[i].key.equals(key)){
                return true;
            }
        }
        return false;
    }
}
