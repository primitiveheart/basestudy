package com.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by admin on 2018/5/19.
 */
public class Demo2Action extends ActionSupport {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(name);
        System.out.println(age);
        return null;
    }
}
