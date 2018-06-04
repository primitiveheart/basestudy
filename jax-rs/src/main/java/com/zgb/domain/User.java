package com.zgb.domain;

/**
 * Created by admin on 2018/6/3.
 */

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "user")
public class User implements Serializable{
    private int id;
    private String name;
    private String profession;

    public User(int id, String name, String profession) {
        this.id = id;
        this.name = name;
        this.profession = profession;
    }

    public User() {
    }

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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
