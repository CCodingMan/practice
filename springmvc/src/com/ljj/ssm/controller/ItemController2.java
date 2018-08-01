package com.ljj.ssm.controller;

import com.ljj.ssm.bo.Items;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/31 18:37
 * @Description:
 */
public class ItemController2 implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        List<Items> itemsList = new ArrayList<>();

        Items items1 = new Items();
        items1.setId(1);
        items1.setName("虾");
        items1.setPrice(new BigDecimal(10.00));

        Items items2 = new Items();
        items2.setId(2);
        items2.setName("螃蟹");
        items2.setPrice(new BigDecimal(20.00));

        Items items3 = new Items();
        items3.setId(3);
        items3.setName("鲨鱼");
        items3.setPrice(new BigDecimal(30.00));

        itemsList.add(items1);
        itemsList.add(items2);
        itemsList.add(items3);

        //设置模型数据
        httpServletRequest.setAttribute("itemsList",itemsList);
        //设置转发的视图
        httpServletRequest.getRequestDispatcher("items/itemsList")
                .forward(httpServletRequest,httpServletResponse);
    }
}
