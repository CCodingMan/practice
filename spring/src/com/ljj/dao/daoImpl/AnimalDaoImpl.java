package com.ljj.dao.daoImpl;

import com.ljj.bo.Animal;
import com.ljj.dao.IAnimalDao;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/11 15:49
 * @Description:
 */
public class AnimalDaoImpl implements IAnimalDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void add(Animal animal) {
        hibernateTemplate.save(animal);

    }

    @Override
    public Animal getObject(int id) {
        return hibernateTemplate.get(Animal.class, id);
    }

    @Override
    public List<Animal> listOjbect() {
        return (List<Animal>) hibernateTemplate.find("from Animal");
    }
}
