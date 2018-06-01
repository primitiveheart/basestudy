package com.web.service;


import com.web.dao.UserDao;

/**
 * Created by admin on 2018/5/23.
 */
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(){
        System.out.println("service的保存方法");
        userDao.save();
    }
}
