package com.ljj.bo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @Auther: ljj
 * @Date: 2018/7/10 14:33
 * @Description:
 */
@Aspect
public class TestAnnoAOPAdvice {
    @Before(value = "execution(* com.ljj.bo.TestAnnoAOP.add(..))")
    public void before(){
        System.out.println("TestAnnoAOPAdvice before....");
    }

    @After(value = "execution(* com.ljj.bo.TestAnnoAOP.add(..))")
    public void after(){
        System.out.println("TestAnnoAOPAdvice after....");
    }

//    @Around()
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("TestAnnoAOPAdvice 方法前....");

        proceedingJoinPoint.proceed();

        System.out.println("TestAnnoAOPAdvice 方法后....");
    }
}
