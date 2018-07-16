package com.ljj.test;

import com.ljj.bo.Car;
import com.ljj.bo.Watch;
import com.ljj.util.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/16 14:49
 * @Description:
 */
public class HibernateTest {
    @Test
    public void testAdd(){
//        //（1）加载核心配置文件(到src下找hibernate.cfg.xml文件)
//        Configuration configuration = new Configuration();
//        configuration.configure();
//
//        //（2）创建sessionFactory对象（读取hibernate.cfg.xml文件，获取信息，并根据映射文件创建表）
//        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //通过工具类静态代码块获取sessionFaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        //（3）使用sessionFactory创建session对象
        Session session = sessionFactory.openSession();

        //（4）开启事务
        Transaction transaction = session.beginTransaction();

        //（5）写具体逻辑crud
        //添加
        Car car = new Car();
        car.setName("奔驰");
        car.setPrice(new BigDecimal(200000.00));
        session.save(car);

        //（6）提交事务
        transaction.commit();

        //（7）关闭资源
        session.close();
        sessionFactory.close();

    }

    @Test
    public void testAddTransaction(){
        Transaction ts = null;
        try {
            //（3）使用sessionFactory创建session对象
            Session session = HibernateUtil.getSession();

            //（4）开启事务
            ts = session.beginTransaction();

            //（5）写具体逻辑crud
            //添加

            Car car = new Car();
            car.setName("奔驰");
            car.setPrice(new BigDecimal(300000.00));
            session.save(car);

            //（6）提交事务
            ts.commit();
        }catch (Exception e){
            ts.rollback();
            e.printStackTrace();
        }
    }

    @Test
    public void testAddWatch(){
        Transaction ts = null;
        Session session = null;
        try {
            //（3）使用sessionFactory创建session对象
            session = HibernateUtil.getSession();

            //（4）开启事务
            ts = session.beginTransaction();

            //（5）写具体逻辑crud
            //添加

            Watch watch = new Watch();
            watch.setName("暴龙");
            session.save(watch);

            //（6）提交事务
            ts.commit();
        }catch (Exception e){
            ts.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Test
    public void testDelete(){
        //获取sessionFaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        //（3）使用sessionFactory创建session对象
        Session session = sessionFactory.openSession();

        //（4）开启事务
        Transaction transaction = session.beginTransaction();

        //（5）写具体逻辑crud
        //删除
        Car car = session.get(Car.class, 1);
        session.delete(car);

        //（6）提交事务
        transaction.commit();

        //（7）关闭资源
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testUpdate(){
        //获取sessionFaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        //（3）使用sessionFactory创建session对象
        Session session = sessionFactory.openSession();

        //（4）开启事务
        Transaction transaction = session.beginTransaction();

        //（5）写具体逻辑crud
        //修改
        Car car = session.get(Car.class, 1);
        car.setName("宝马");
        session.update(car);

        //（6）提交事务
        transaction.commit();

        //（7）关闭资源
        session.close();
        sessionFactory.close();

    }

    @Test
    public void testGet(){
        //获取sessionFaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        //（3）使用sessionFactory创建session对象
        Session session = sessionFactory.openSession();

        //（4）开启事务
        Transaction transaction = session.beginTransaction();

        //（5）写具体逻辑crud
        //根据id查询
        Car car = session.get(Car.class, 1);
        System.out.println(car);

        //（6）提交事务
        transaction.commit();

        //（7）关闭资源
        session.close();
        sessionFactory.close();

    }

    @Test
    public void testQuery(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction ts = null;
        try {

            sessionFactory = HibernateUtil.getSessionFactory();

            //（3）使用sessionFactory创建session对象
            session = sessionFactory.openSession();

            //（4）开启事务
            ts = session.beginTransaction();

            //（5）写具体逻辑crud
            //创建Query对象
            Query query = session.createQuery("from Car");
            //调用query对象里的方法获得结果
            List<Car> list = query.list();
            for (Car car: list){
                System.out.println(car);
            }

            //（6）提交事务
            ts.commit();
        }catch (Exception e){
            e.printStackTrace();
            ts.rollback();
        }finally {
            session.close();
            sessionFactory.close();
        }

    }

    @Test
    public void testCriteria(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction ts = null;
        try {

            sessionFactory = HibernateUtil.getSessionFactory();

            //（3）使用sessionFactory创建session对象
            session = sessionFactory.openSession();

            //（4）开启事务
            ts = session.beginTransaction();

            //（5）写具体逻辑crud

//            //(hibernate5.2以前)
//            List<Car> list = session.createCriteria(Car.class).list();

            //创建Criteria对象(hibernate5.2以后)
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
            Root<Car> root = criteriaQuery.from(Car.class);
            criteriaQuery.select(root);
//            criteriaQuery.where( criteriaBuilder.equal( root.get("name"), "奥迪" ) );

            //调用Criteria对象里的方法获得结果(hibernate5.2以后)
            List<Car> list = session.createQuery( criteriaQuery ).getResultList();
            for (Car car: list){
                System.out.println(car);
            }

            //（6）提交事务
            ts.commit();
        }catch (Exception e){
            e.printStackTrace();
            ts.rollback();
        }finally {
            session.close();
            sessionFactory.close();
        }

    }

    @Test
    public void testSQLQuery(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction ts = null;
        try {

            sessionFactory = HibernateUtil.getSessionFactory();

            //（3）使用sessionFactory创建session对象
            session = sessionFactory.openSession();

            //（4）开启事务
            ts = session.beginTransaction();

            //（5）写具体逻辑crud
//            //创建SQLQuery对象(hibernate5.2以前)
//            SQLQuery query = session.createSQLQuery("select * from t_car");
//            query.addEntity(Car.class);

            //创建SQLQuery对象(hibernate5.2以后)
            NativeQuery query = session.createSQLQuery("select * from t_car");
            query.addEntity(Car.class);

            //调用SQLQuery对象里的方法获得结果
            List<Car> list = query.list();
            for (Car car: list){
                System.out.println(car);
            }

            //（6）提交事务
            ts.commit();
        }catch (Exception e){
            e.printStackTrace();
            ts.rollback();
        }finally {
            session.close();
            sessionFactory.close();
        }

    }
}
