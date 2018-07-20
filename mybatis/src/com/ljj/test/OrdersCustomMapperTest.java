package com.ljj.test;

import com.ljj.bo.O_orders;
import com.ljj.bo.O_user;
import com.ljj.bo.OrdersCustom;
import com.ljj.bo.User;
import com.ljj.mapper.OrdersCustomMapper;
import com.ljj.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: ljj
 * @Date: 2018/7/19 14:14
 * @Description:
 */
public class OrdersCustomMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findOrdersUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建接口实现类代理对象
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
        List<OrdersCustom> list = ordersCustomMapper.findOrdersUser();
        sqlSession.close();
        for (OrdersCustom obj: list){
            System.out.println("userId:"+obj.getUserId()+",userName:"+obj.getUserName()+",orderId:"+obj.getId());
        }
    }

    @Test
    public void findOrdersUserResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建接口实现类代理对象
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
        List<O_orders> list = ordersCustomMapper.findOrdersUserResultMap();
        sqlSession.close();
        for (O_orders obj: list){
            System.out.println("userId:"+obj.getUser().getId()+",userName:"+obj.getUser().getUsername()+",orderId:"+obj.getId());
        }
    }

    @Test
    public void findOrdersAndOrderdetailResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建接口实现类代理对象
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
        List<O_orders> list = ordersCustomMapper.findOrdersAndOrderdetailResultMap();
        sqlSession.close();
        for (O_orders obj: list){
            System.out.println("userId:"+obj.getUser().getId()+",userName:"+obj.getUser().getUsername()+",orderId:"+obj.getId());
            System.out.println("itemsnumber:"+obj.getOrderdetails().get(0).getItemsnumber());
        }
    }

    @Test
    public void findOrdersAndItemsResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建接口实现类代理对象
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
        List<O_user> list = ordersCustomMapper.findOrdersAndItemsResultMap();
        sqlSession.close();
        for (O_user obj: list){
            System.out.println("userId:"+obj.getOrdersList().get(0).getUserId()
                    +",userName:"+obj.getUsername()+",orderId:"
                    +obj.getOrdersList().get(0).getId());
            System.out.println("itemsnumber:"+obj.getOrdersList().get(0).getOrderdetails().get(0).getItemsnumber());
            System.out.println("price:"+obj.getOrdersList().get(0).getOrderdetails().get(0).getItems().getPrice());
        }
    }

    @Test
    public void findOrderUserLazyLoad() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建接口实现类代理对象
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
        List<O_orders> list = ordersCustomMapper.findOrderUserLazyLoad();
        sqlSession.close();
        for (O_orders obj: list){
            System.out.println("orderId:"+obj.getId());
            System.out.println("userId:"+obj.getUser().getId()
                    +",userName:"+obj.getUser().getUsername());
        }
    }
}