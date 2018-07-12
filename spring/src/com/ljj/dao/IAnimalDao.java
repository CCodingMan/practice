package com.ljj.dao;

import com.ljj.bo.Animal;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/11 15:49
 * @Description:
 */
public interface IAnimalDao {
    void add(Animal animal);

    Animal getObject(int id);

    List<Animal> listOjbect();

}
