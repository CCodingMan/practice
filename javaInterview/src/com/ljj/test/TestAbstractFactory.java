package com.ljj.test;

import com.ljj.service.IFactory;
import com.ljj.serviceImpl.Factory;

import java.util.Collections;

/**
 * @Auther: ljj
 * @Date: 2018/7/21 20:01
 * @Description:
 */
public class TestAbstractFactory {
    public static void main(String[] args) {
        IFactory factory = new Factory();
        factory.createProduct().show();
    }

}
