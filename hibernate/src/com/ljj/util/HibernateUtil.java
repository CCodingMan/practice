package com.ljj.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @Auther: ljj
 * @Date: 2018/7/16 15:49
 * @Description:
 */
public class HibernateUtil {
    private static final Configuration configuration;
    private static final SessionFactory sessionFactory;
    static {
        //（1）加载核心配置文件(到src下找hibernate.cfg.xml文件)
        configuration = new Configuration();
        configuration.configure();

        //（2）创建sessionFactory对象（读取hibernate.cfg.xml文件，获取信息，并根据映射文件创建表）
        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public static void main(String[] args) {

    }
}
