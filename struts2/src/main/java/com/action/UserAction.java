package com.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by admin on 2018/5/19.
 */
public class UserAction extends ActionSupport {

    public UserAction(){
        System.out.println("该类实例化了");
    }
    public String add(){
        System.out.println("add方法执行了");
        return "success";
    }
    public String edit(){
        System.out.println("edit方法执行了");
        return "success";
    }
    public String delete(){
        System.out.println("delete方法执行了");
        return "success";
    }
}
