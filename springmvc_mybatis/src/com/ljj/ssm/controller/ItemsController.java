package com.ljj.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.ljj.ssm.po.ItemsCustom;
import com.ljj.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/8/2 21:52
 * @Description:
 */
@Controller
//为了对url进行分类管理，可以在此处定义根路径，最终访问路径为根路径+子路径
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    //建议方法名和注解名称保持一致
    @RequestMapping(value = "/queryItems", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView queryItems() throws Exception{

        List<ItemsCustom> itemsList = itemsService.findItemsList(null);

        //设置数据模型
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);

        //指定视图
        modelAndView.setViewName("items/itemsList");

        return modelAndView;
    }

    @RequestMapping(value = "/editItems", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView editItems(@RequestParam(value = "id", required = true) Integer items_id) throws Exception{

        ItemsCustom itemsCustom = itemsService.selectByPrimaryKey(items_id);

        //设置数据模型
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsCustom",itemsCustom);

        //指定视图
        modelAndView.setViewName("items/editItems");

        return modelAndView;
    }

    @RequestMapping(value = "/editItems2", method = {RequestMethod.POST,RequestMethod.GET})
    public String editItems2(Model model) throws Exception{

        ItemsCustom itemsCustom = itemsService.selectByPrimaryKey(1);

        //设置数据模型
        model.addAttribute("itemsCustom",itemsCustom);

        return "items/editItems";
    }

    @RequestMapping(value = "/editItemsSubmit", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView editItemsSubmit(Integer id, ItemsCustom itemsCustom) throws Exception{

        //设置数据模型
        ModelAndView modelAndView = new ModelAndView();

        //指定视图
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping(value = "/editItemsSubmit2", method = {RequestMethod.POST,RequestMethod.GET})
    public String editItemsSubmit2(@RequestParam(value = "id",required = true) Integer id
            , ItemsCustom itemsCustom) throws Exception{

        if(id != null){
            itemsService.updateByPrimaryKeyWithBLOBs(id, itemsCustom);
        }else{
            return "fail";
        }

        return "redirect:queryItems.action";
    }

    @RequestMapping(value = "/editItemsSubmit3", method = {RequestMethod.POST,RequestMethod.GET})
    public String editItemsSubmit3(Integer id, ItemsCustom itemsCustom) throws Exception{



        return "forward:queryItems.action";
    }

    @RequestMapping(value = "/editItemsSubmit4", method = {RequestMethod.POST,RequestMethod.GET})
    public void editItemsSubmit4(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<ItemsCustom> itemsList = itemsService.findItemsList(null);
        request.setAttribute("itemsList",itemsList);
        request.getRequestDispatcher("/WEB-INF/jsp/items/itemsList.jsp").forward(request,response);
    }

    @RequestMapping(value = "/editItemsSubmit5", method = {RequestMethod.POST,RequestMethod.GET})
    public void editItemsSubmit5(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.sendRedirect("queryItems.action");
    }

}
