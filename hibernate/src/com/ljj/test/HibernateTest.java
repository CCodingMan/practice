package com.ljj.test;

import com.ljj.bo.*;
import com.ljj.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

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
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Car.class);
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

    @Test
    public void testOneToMany(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction ts = null;
        try {

            sessionFactory = HibernateUtil.getSessionFactory();

            //（3）使用sessionFactory创建session对象
            session = sessionFactory.openSession();

            //（4）开启事务
            ts = session.beginTransaction();

            Customer customer = new Customer();
            customer.setCustLevel("vip");
            customer.setCustMobile("999");
            customer.setCustName("创智博客");
            customer.setCustPhone("110");
            customer.setCustSource("网络");

            LinkMan linkMan = new LinkMan();
            linkMan.setLkm_gender("男");
            linkMan.setLkm_name("lucy");
            linkMan.setLkm_phone("911");

            customer.getSetLinkMan().add(linkMan);
//            linkMan.setCustomer(customer);
//
            session.save(customer);
//            session.save(linkMan);

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
    public void testOneToManyDelete(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction ts = null;
        try {

            sessionFactory = HibernateUtil.getSessionFactory();

            //（3）使用sessionFactory创建session对象
            session = sessionFactory.openSession();

            //（4）开启事务
            ts = session.beginTransaction();

            Customer customer = session.get(Customer.class, 2);
            session.delete(customer);

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
    public void testOneToManyUpdate(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction ts = null;
        try {

            sessionFactory = HibernateUtil.getSessionFactory();

            //（3）使用sessionFactory创建session对象
            session = sessionFactory.openSession();

            //（4）开启事务
            ts = session.beginTransaction();

            //持久态自动更新
            Customer customer = session.get(Customer.class, 3);
            LinkMan linkMan = session.get(LinkMan.class, 3);
            customer.getSetLinkMan().add(linkMan);
            linkMan.setCustomer(customer);

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

    /**
     * 对象导航查询
     */
    @Test
    public void testOneToManyObjectQuery(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction ts = null;
        try {

            sessionFactory = HibernateUtil.getSessionFactory();

            //（3）使用sessionFactory创建session对象
            session = sessionFactory.openSession();

            //（4）开启事务
            ts = session.beginTransaction();

            Customer customer = session.get(Customer.class, 3);
            Set<LinkMan> setLinkMan = customer.getSetLinkMan();

            System.out.println(setLinkMan.size());

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

    /**
     * hql查询
     */
    @Test
    public void testOneToManyHQLQuery(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction ts = null;
        try {

            sessionFactory = HibernateUtil.getSessionFactory();

            //（3）使用sessionFactory创建session对象
            session = sessionFactory.openSession();

            //（4）开启事务
            ts = session.beginTransaction();

            //1.查询所有客户
//            Query query = session.createQuery("from Customer");
//            List<Customer> customers = query.list();

            //2.条件查询(高版本的hibernate占位符使用?0或:参数命名，低版本使用?)
//            Query query = session.createQuery("from Customer where cid=:cid");
//            query.setParameter("cid", 3);
//            Query query = session.createQuery("from Customer where custName like :custName");
//            query.setParameter("custName","%李%");
//            List<Customer> customers = query.list();

            //3.排序查询
//            Query query = session.createQuery("from Customer order by cid desc");
//            List<Customer> customers = query.list();

            //4.分页查询
//            Query query = session.createQuery("from Customer");
//            query.setFirstResult(0);
//            query.setMaxResults(2);
//            List<Customer> customers = query.list();

            //5.投影查询
//            Query query = session.createQuery("select custName from Customer");
//            List<Object> customers = query.list();
//            for (Object obj: customers){
//                System.out.println(obj);
//            }

            //6.聚合函数查询
            //count
//            Query query = session.createQuery("select count(*) from Customer");
//            Long ob = (Long)query.uniqueResult();
//            int count = ob.intValue();
//            System.out.println(count);

            //sum
//            Query query = session.createQuery("select sum(cid) as sum from Customer");
//            Long ob = (Long)query.uniqueResult();
//            int sum = ob.intValue();
//            System.out.println(sum);

            //avg
//            Query query = session.createQuery("select avg(cid) as avg from Customer");
//            Double avg = (Double)query.uniqueResult();
//            System.out.println(avg);

            //max
//            Query query = session.createQuery("select max(cid) as max from Customer");
//            int max = (Integer) query.uniqueResult();
//            System.out.println(max);

            //min
            Query query = session.createQuery("select min(cid) as min from Customer");
            int min = (Integer) query.uniqueResult();
            System.out.println(min);


//            for (Customer obj: customers){
//                System.out.println("customerName: "+obj.getCustName()+",customerLevel: "+obj.getCustLevel());
//            }

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

    /**
     * qbc查询(criteria对象)
     */
    @Test
    public void testOneToManyQBCQuery(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction ts = null;
        try {

            sessionFactory = HibernateUtil.getSessionFactory();

            //（3）使用sessionFactory创建session对象
            session = sessionFactory.openSession();

            //（4）开启事务
            ts = session.beginTransaction();

            //1.查询所有客户
            //低版本hibernate
//            Criteria criteria = session.createQuery(Customer.class);
            //高版本hibernate5.3
//            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//            CriteriaQuery criteria = criteriaBuilder.createQuery(Customer.class);
//            Root<Customer> root = criteria.from(Customer.class);
//            //criteria.where( criteriaBuilder.equal( root.get("custName"), "张三" ) );
//            List<Customer> customers = session.createQuery(criteria).list();


            //2.条件查询
            //低版本
//            Criteria criteria = session.createQuery(Customer.class);
//          //criteria.add(Restrictions.eq("custName","张三"));
//            criteria.add(Restrictions.like("custName","%张%"));
//            List<Customer> customers = criteria.list();
//
            //高版本hibernate5.3
//            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//            CriteriaQuery criteria = criteriaBuilder.createQuery(Customer.class);
//            Root<Customer> root = criteria.from(Customer.class);
//            criteria.where( criteriaBuilder.equal( root.get("custName"), "张三" ) );
//            List<Customer> customers = session.createQuery(criteria).list();


            //3.排序查询
            //低版本
//            Criteria criteria = session.createQuery(Customer.class);
//            criteria.addOrder(Order.desc("cid"));
//            List<Customer> customers = criteria.list();
//
//            //高版本hibernate5
//            //1.创建CriteriaBuilder对象，用来构建查询条件
//            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//            //2.构建CriteriaQuery对象,同时指定的是查询的返回的结果类型
//            CriteriaQuery criteria = criteriaBuilder.createQuery(Customer.class);
//            //2.1指定查询哪个类
//            Root<Customer> root = criteria.from(Customer.class);
//            criteria.orderBy(criteriaBuilder.desc(root.get("cid")));
//            List<Customer> customers = session.createQuery(criteria).list();

            //4.分页查询
            //低版本
//            Criteria criteria = session.createQuery(Customer.class);
//            criteria.setFirstResult(0);
//            criteria.setMaxResults(2);
//            List<Customer> customers = criteria.list();
//
//            //高版本hibernate5.3
//            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//            CriteriaQuery criteria = criteriaBuilder.createQuery(Customer.class);
//            Root<Customer> root = criteria.from(Customer.class);
//            Query<Customer> query = session.createQuery(criteria);
//            query.setFirstResult(0);
//            query.setMaxResults(2);
//            List<Customer> customers = query.list();


            //5.统计查询
//            //低版本
//            Criteria criteria = session.createQuery(Customer.class);
//            criteria.setProjection(Projections.rowCount());
//            Long lobj = (Long)criteria.uniqueResult();
//            int count = lobj.intValue();
//            System.out.println(count);

            //高版本hibernate5.3
//            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//            CriteriaQuery<Long> criteria = criteriaBuilder.createQuery(Long.class);
//            Root<Customer> root = criteria.from(Customer.class);
//            criteria.select(criteriaBuilder.count(root.get("cid")));
//            Long count = session.createQuery(criteria).uniqueResult();
//            System.out.println(count);

            //6.离线查询
            DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
            Criteria criteria = detachedCriteria.getExecutableCriteria(session);
            List<Customer> customers = criteria.list();

            for (Customer obj: customers){
                System.out.println("customerName: "+obj.getCustName()+",customerLevel: "+obj.getCustLevel());
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
    public void testManyToMany(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction ts = null;
        try {

            sessionFactory = HibernateUtil.getSessionFactory();

            //（3）使用sessionFactory创建session对象
            session = sessionFactory.openSession();

            //（4）开启事务
            ts = session.beginTransaction();

            User user = new User();
            user.setUser_name("ljj");
            user.setUser_password("111");

            User user2 = new User();
            user2.setUser_name("zhangsan");
            user2.setUser_password("222");


            Role role = new Role();
            role.setRole_name("管理员");
            role.setRole_memo("老大");

            Role role2 = new Role();
            role2.setRole_name("值守员");
            role2.setRole_memo("老二");

            Role role3 = new Role();
            role3.setRole_name("厨师");
            role3.setRole_memo("老三");


            user.getSetRole().add(role);
            user.getSetRole().add(role2);

            user2.getSetRole().add(role2);
            user2.getSetRole().add(role3);

            session.save(user);
            session.save(user2);

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
    public void testManyToManyDelete(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction ts = null;
        try {

            sessionFactory = HibernateUtil.getSessionFactory();

            //（3）使用sessionFactory创建session对象
            session = sessionFactory.openSession();

            //（4）开启事务
            ts = session.beginTransaction();

            User user = session.get(User.class, 1);
            session.delete(user);

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

    /**
     * 通过第三张表维护：让某用户拥有某角色,或移除某角色
     */
    @Test
    public void testManyToManyTable(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction ts = null;
        try {

            sessionFactory = HibernateUtil.getSessionFactory();

            //（3）使用sessionFactory创建session对象
            session = sessionFactory.openSession();

            //（4）开启事务
            ts = session.beginTransaction();

            //让某人拥有某角色
            User user = session.get(User.class, 1);
            Role role = session.get(Role.class, 3);
            user.getSetRole().add(role);

            //让某人没有某角色
//            User user = session.get(User.class, 1);
//            Role role = session.get(Role.class, 3);
//            user.getSetRole().remove(role);

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
