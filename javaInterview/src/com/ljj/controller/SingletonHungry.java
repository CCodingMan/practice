package com.ljj.controller;

/**
 * @Auther: ljj
 * @Date: 2018/7/21 19:14
 * @Description:单例模式-饿汉模式
 */
public class SingletonHungry {
    //实例化
    private static final SingletonHungry singletonHungry = new SingletonHungry();
    //私有构造函数
    private SingletonHungry(){}
    //返回实例对象
    public static SingletonHungry getInstance(){
        return singletonHungry;
    }
}
