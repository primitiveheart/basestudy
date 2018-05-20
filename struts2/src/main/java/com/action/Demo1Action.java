package com.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by admin on 2018/5/19.
 */
public class Demo1Action extends ActionSupport {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(name);
        return null;
    }
}
