package com.ljj.bo;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Auther: ljj
 * @Date: 2018/7/10 10:59
 * @Description:
 */
public class AdviceBook {
    public void before(){
        System.out.println("前置增强");
    }

    public void after(){
        System.out.println("后置增强");
    }

    /**
     * 环绕增强
     * @param proceedingJoinPoint
     * @throws Throwable
     */
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("方法之前");

        proceedingJoinPoint.proceed();

        System.out.println("方法之后");
    }

}
