package com.ljj.service;

import com.ljj.dao.TestOrderDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: ljj
 * @Date: 2018/7/11 00:01
 * @Description:
 */
@Transactional
public class TestOrderService {
    private TestOrderDao testOrderDao;

    public void setTestOrderDao(TestOrderDao testOrderDao) {
        this.testOrderDao = testOrderDao;
    }

    public void accountMoney(int money, String userNameLessMoney, String userNameMoreMoney){
        testOrderDao.lessMoney(money, userNameLessMoney);

        testOrderDao.moreMoney(money, userNameMoreMoney);
    }
}
