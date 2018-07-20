package com.ljj.mapper;

import com.ljj.bo.O_orders;
import com.ljj.bo.O_user;
import com.ljj.bo.OrdersCustom;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/19 13:23
 * @Description:订单映射接口
 */
public interface OrdersCustomMapper {
    List<OrdersCustom> findOrdersUser() throws Exception;

    List<O_orders> findOrdersUserResultMap() throws Exception;

    List<O_orders> findOrdersAndOrderdetailResultMap() throws Exception;

    List<O_user> findOrdersAndItemsResultMap() throws Exception;

    List<O_orders> findOrderUserLazyLoad() throws Exception;

}
