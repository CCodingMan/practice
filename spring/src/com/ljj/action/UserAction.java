package com.ljj.action;

import com.ljj.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: ljj
 * @Date: 2018/7/10 12:37
 * @Description:
 */
public class UserAction extends ActionSupport {
    @Override
    public String execute() {
        System.out.println("action...");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContent.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.add();

        return NONE;
    }
}
