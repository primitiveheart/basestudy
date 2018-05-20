package com.action;

import com.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by admin on 2018/5/19.
 */
public class Demo4Action extends ActionSupport implements ModelDriven<User>{

    private User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(user.getName() + "----" + user.getAge());
        return null;
    }

    @Override
    public User getModel() {
        return user;
    }
}
