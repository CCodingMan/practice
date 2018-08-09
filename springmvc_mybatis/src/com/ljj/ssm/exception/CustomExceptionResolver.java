package com.ljj.ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: ljj
 * @Date: 2018/8/9 21:38
 * @Description:
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        //解析出异常类型
        //如果该异常类型是系统自定义的异常，直接取出异常信息，在错误页面展示
        CustomException customException = null;
        if(e instanceof CustomException){
            customException = (CustomException)e;
        }else{
            //如果该异常类型不是系统自定义的异常看，构造一个自定义的异常类型(信息为”未知错误”)
            customException = new CustomException("未知错误");
        }

        String message = customException.getMessage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",message);
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
