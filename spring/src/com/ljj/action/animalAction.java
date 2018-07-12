package com.ljj.action;

import com.ljj.bo.Animal;
import com.ljj.service.AnimalService;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2018/7/11 11:44
 * @Description:
 */
public class animalAction extends ActionSupport {
    private AnimalService animalService;

    public void setAnimalService(AnimalService animalService) {
        this.animalService = animalService;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("action......");

//        Animal animal = new Animal();
//        animal.setName("大熊猫");
//        animal.setAge(2);
//        animalService.add(animal);

        Animal animal = animalService.getObject(3);
        System.out.println(animal.toString());

        List<Animal> list = animalService.listObject();
        for(Animal a : list){
            System.out.println(a.toString());
        }

        return NONE;
    }
}
