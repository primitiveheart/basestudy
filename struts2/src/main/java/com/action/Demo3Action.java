package com.action;

import com.domain.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by admin on 2018/5/19.
 */
public class Demo3Action extends ActionSupport {

    private User user;

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
}
