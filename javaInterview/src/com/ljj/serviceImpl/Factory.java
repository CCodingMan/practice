package com.ljj.serviceImpl;

import com.ljj.service.IFactory;
import com.ljj.service.IProduct;

/**
 * @Auther: ljj
 * @Date: 2018/7/21 19:59
 * @Description:
 */
public class Factory implements IFactory {
    @Override
    public IProduct createProduct() {
        return new Product();
    }
}
