package com.ljj.ssm.controller;

import com.ljj.ssm.po.Items;
import com.ljj.ssm.po.ItemsCustom;
import com.ljj.ssm.service.ItemsService;
import com.ljj.ssm.service.impl.ItemsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/8/2 21:52
 * @Description:
 */
@Controller
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    //建议方法名和注解名称保持一致
    @RequestMapping("/queryItems")
    public ModelAndView queryItems() throws Exception{

        List<ItemsCustom> itemsList = itemsService.findItemsList(null);

        //设置数据模型
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);

        //指定视图
        modelAndView.setViewName("items/itemsList");

        return modelAndView;
    }

    @RequestMapping("/editItems")
    public ModelAndView editItems(Integer id) throws Exception{

        ItemsCustom itemsCustom = itemsService.selectByPrimaryKey(1);

        //设置数据模型
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsCustom",itemsCustom);

        //指定视图
        modelAndView.setViewName("items/editItems");

        return modelAndView;
    }

    @RequestMapping("/editItemsSubmit")
    public ModelAndView editItemsSubmit(Integer id, ItemsCustom itemsCustom) throws Exception{

        //设置数据模型
        ModelAndView modelAndView = new ModelAndView();

        //指定视图
        modelAndView.setViewName("success");

        return modelAndView;
    }
}
