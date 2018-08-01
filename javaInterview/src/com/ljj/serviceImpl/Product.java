package com.ljj.serviceImpl;

import com.ljj.service.IProduct;

/**
 * @Auther: ljj
 * @Date: 2018/7/21 19:44
 * @Description:工厂模式-产品
 */
public class Product implements IProduct {
    @Override
    public void show() {
        System.out.println("产品");
    }
}
