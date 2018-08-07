package com.ljj.ssm.po;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/8/2 18:19
 * @Description:商品包装对象
 */
public class ItemsQueryVo {
    private Items items;
    private ItemsCustom itemsCustom;
    private List<ItemsCustom> itemList;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }

    public List<ItemsCustom> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemsCustom> itemList) {
        this.itemList = itemList;
    }
}
