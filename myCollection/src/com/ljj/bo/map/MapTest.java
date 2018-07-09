package com.ljj.bo.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Auther: ljj
 * @Date: 2018/7/8 10:32
 * @Description:map测试类
 */
public class MapTest {
    public static void main(String[] args) {
        String[] str = "this is a goods man that he is handsome".split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String arr:str) {
            if(!map.containsKey(arr)){
                map.put(arr,1);
            }else {
                map.put(arr,map.get(arr)+1);
            }
        }

        for(Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator(); iterator.hasNext();){
            String key = iterator.next().getKey();
            System.out.println(key+"--->"+map.get(key));
        }

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }
}
