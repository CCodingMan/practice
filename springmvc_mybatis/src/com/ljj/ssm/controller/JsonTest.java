package com.ljj.ssm.controller;

import com.ljj.ssm.po.ItemsCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: ljj
 * @Date: 2018/8/15 22:23
 * @Description:
 */
@Controller
public class JsonTest {
    //请求json,输出json
    @RequestMapping("/requestJson")
    public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){
        //...转换输出
        return itemsCustom;
    }

    //请求key/value,输出json
    @RequestMapping("/responseJson")
    public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom){
        //...转换输出
        return itemsCustom;
    }
}
