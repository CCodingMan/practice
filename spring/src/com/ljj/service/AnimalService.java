package com.ljj.service;

import com.ljj.bo.Animal;
import com.ljj.dao.IAnimalDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/11 15:49
 * @Description:
 */
@Transactional
public class AnimalService {
    private IAnimalDao iAnimalDao;

    public void setiAnimalDao(IAnimalDao iAnimalDao) {
        this.iAnimalDao = iAnimalDao;
    }

    public void add(Animal animal){
        System.out.println("service add....");
        iAnimalDao.add(animal);
    }

    public Animal getObject(int id){
        return iAnimalDao.getObject(id);
    }

    public List<Animal> listObject(){
        return iAnimalDao.listOjbect();
    }
}
