package com.serviceimpl;

import com.dao.UserDao;
import com.daoimpl.UserDaoImpl;
import com.service.UserService;
import com.vo.User;

/**
 * Created by admin on 2018/5/17.
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        return userDao.find(username, password);
    }
}
