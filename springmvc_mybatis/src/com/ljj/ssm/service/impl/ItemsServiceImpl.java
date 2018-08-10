package com.ljj.ssm.service.impl;

import com.ljj.ssm.exception.CustomException;
import com.ljj.ssm.mapper.ItemsMapper;
import com.ljj.ssm.mapper.ItemsMapperCustom;
import com.ljj.ssm.po.Items;
import com.ljj.ssm.po.ItemsCustom;
import com.ljj.ssm.po.ItemsQueryVo;
import com.ljj.ssm.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/8/2 18:43
 * @Description:
 */
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }

    @Override
    public ItemsCustom selectByPrimaryKey(Integer id) throws Exception {
        Items items = itemsMapper.selectByPrimaryKey(id);
        if(items == null){
            throw new CustomException("商品不存在");
        }
        //其他处理。。。

        ItemsCustom itemsCustom = null;
        if(items != null){
            itemsCustom = new ItemsCustom();
            //把items的属性值拷贝到itemsCustom中
            BeanUtils.copyProperties(items, itemsCustom);
        }

        return itemsCustom;
    }

    @Override
    public void updateByPrimaryKeyWithBLOBs(Integer id, ItemsCustom itemsCustom) throws Exception {
        //添加业务校验，通常在service对关键参数进行校验
        //校验id为空，抛出异常
        if (id != null){
            itemsCustom.setId(id);
            itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
        }else{
            System.out.println("id is null");
        }
    }
}
