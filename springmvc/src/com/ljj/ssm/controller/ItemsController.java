package com.ljj.ssm.controller;

import com.ljj.ssm.bo.Items;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/31 12:45
 * @Description:
 */
public class ItemsController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<Items> itemsList = new ArrayList<>();

        Items items1 = new Items();
        items1.setId(1);
        items1.setName("辣条");
        items1.setPrice(new BigDecimal(10.00));

        Items items2 = new Items();
        items2.setId(2);
        items2.setName("洗衣粉");
        items2.setPrice(new BigDecimal(20.00));

        Items items3 = new Items();
        items3.setId(3);
        items3.setName("果冻");
        items3.setPrice(new BigDecimal(30.00));

        itemsList.add(items1);
        itemsList.add(items2);
        itemsList.add(items3);

        //设置数据模型
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);

        //指定视图
        modelAndView.setViewName("items/itemsList");

        return modelAndView;
    }
}
