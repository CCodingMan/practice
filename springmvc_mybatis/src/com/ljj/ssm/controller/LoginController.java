package com.ljj.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Auther: ljj
 * @Date: 2018/8/26 14:54
 * @Description:
 */
@Controller
public class LoginController {
    //登录
    @RequestMapping("/login")
    public String login(HttpSession httpSession, String userName, String password){
        //调用service进行用户身份验证...

        httpSession.setAttribute("userName",userName);
        httpSession.setAttribute("password",password);

        return "redirect:items/queryItems.action";
    }

    //退出
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        //清除session
        httpSession.invalidate();

        return "redirect:logout.action";
    }
}
