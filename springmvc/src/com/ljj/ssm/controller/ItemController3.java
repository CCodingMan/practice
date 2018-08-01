package com.ljj.ssm.controller;

import com.ljj.ssm.bo.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/8/1 10:50
 * @Description:
 */
@Controller
public class ItemController3 {

    //建议方法名和注解名称保持一致
    @RequestMapping("/queryItems")
    public ModelAndView queryItems() throws Exception{
        List<Items> itemsList = new ArrayList<>();

        Items items1 = new Items();
        items1.setId(1);
        items1.setName("窝窝头");
        items1.setPrice(new BigDecimal(10.00));

        Items items2 = new Items();
        items2.setId(2);
        items2.setName("可乐");
        items2.setPrice(new BigDecimal(20.00));

        Items items3 = new Items();
        items3.setId(3);
        items3.setName("果粒橙");
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
