package com.ljj.ssm.mapper;

import com.ljj.ssm.po.ItemsCustom;
import com.ljj.ssm.po.ItemsQueryVo;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/8/2 18:08
 * @Description:
 */
public interface ItemsMapperCustom {
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
