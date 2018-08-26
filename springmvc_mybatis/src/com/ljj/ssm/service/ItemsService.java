package com.ljj.ssm.service;

import com.ljj.ssm.po.ItemsCustom;
import com.ljj.ssm.po.ItemsQueryVo;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/8/2 18:40
 * @Description:
 */
public interface ItemsService {
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

    ItemsCustom selectByPrimaryKey(Integer id) throws Exception;

    void updateByPrimaryKeyWithBLOBs(Integer id, ItemsCustom itemsCustom) throws Exception;


}
