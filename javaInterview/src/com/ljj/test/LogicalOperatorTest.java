package com.ljj.test;

import com.ljj.controller.LogicalOperator;
import org.junit.Test;

/**
 * @Auther: ljj
 * @Date: 2018/7/21 19:02
 * @Description:位运算符
 */
public class LogicalOperatorTest {

    @Test
    public void leftShift() {
        LogicalOperator logicalOperator = new LogicalOperator();
        logicalOperator.leftShift(2, 3);
    }

    @Test
    public void rightShift() {
        LogicalOperator logicalOperator = new LogicalOperator();
        logicalOperator.rightShift(8, 2);
    }
}