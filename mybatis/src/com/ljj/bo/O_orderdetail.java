package com.ljj.bo;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/19 20:44
 * @Description:
 */
public class O_orderdetail {
    private int id;
    private int ordersId;
    private int itemsId;
    private int itemsnumber;
    private O_items items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public int getItemsId() {
        return itemsId;
    }

    public void setItemsId(int itemsId) {
        this.itemsId = itemsId;
    }

    public int getItemsnumber() {
        return itemsnumber;
    }

    public void setItemsnumber(int itemsnumber) {
        this.itemsnumber = itemsnumber;
    }

    public O_items getItems() {
        return items;
    }

    public void setItems(O_items items) {
        this.items = items;
    }
}
