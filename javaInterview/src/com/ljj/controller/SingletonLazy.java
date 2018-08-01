package com.ljj.controller;

/**
 * @Auther: ljj
 * @Date: 2018/7/21 19:14
 * @Description:单例模式-懒汉模式
 */
public class SingletonLazy {
    private static SingletonLazy singletonLazy = null;
    private SingletonLazy(){}
    //静态工厂方法
    public static SingletonLazy getInstance(){
        if(singletonLazy == null){
            synchronized (SingletonLazy.class){
                singletonLazy = new SingletonLazy();
            }

        }
        return singletonLazy;
    }
}
