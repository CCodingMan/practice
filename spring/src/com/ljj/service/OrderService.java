package com.ljj.service;

import com.ljj.dao.OrderDao;

/**
 * @Auther: ljj
 * @Date: 2018/7/10 22:16
 * @Description:
 */
public class OrderService {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void accountMoney(int money, String userNameLessMoney, String userNameMoreMoney){
        orderDao.lessMoney(money, userNameLessMoney);

        orderDao.moreMoney(money, userNameMoreMoney);
    }

}
