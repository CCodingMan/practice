package com.ljj.bo;

import javax.persistence.*;

/**
 * @Auther: ljj
 * @Date: 2018/7/16 23:36
 * @Description:
 */
@Entity
@Table(name = "t_watch")
public class Watch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Watch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
