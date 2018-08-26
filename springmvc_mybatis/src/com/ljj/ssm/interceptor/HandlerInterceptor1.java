package com.ljj.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: ljj
 * @Date: 2018/8/26 10:53
 * @Description:测试拦截器
 */
public class HandlerInterceptor1 implements HandlerInterceptor {

    //进入Handler方法之前执行（身份认证，身份授权）
    //比如身份认证，如果认证不通过表示用户未登录，需要此方法拦截不再往下执行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("HandlerInterceptor1.......preHandle");

        //return true表示放行，return false表示拦截
        return true;
    }

    //进入Handler方法之后，返回ModelAndView之前执行
    //应用场景从ModelAndView出发：将公用的数据模型在这里传到视图，也可以在这里统一指定视图
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("HandlerInterceptor1.......postHandle");

    }

    //执行Handler完成之后执行
    //统一的异常处理，统一的日志处理
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("HandlerInterceptor1.......afterCompletion");
    }
}
