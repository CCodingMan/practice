package com.ljj.controller;

/**
 * @Auther: ljj
 * @Date: 2018/7/21 18:47
 * @Description:位运算符
 */
public class LogicalOperator {
    /**
     * 左移（number*2^index）
     */
    public void leftShift(int number, int index){
        System.out.println(number << index);
    }

    /**
     * 右移(number/2^index)
     */
    public void rightShift(int number, int index){
        System.out.println(number >> index);
    }
}
