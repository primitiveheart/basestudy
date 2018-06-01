package com.annotation.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/5/23.
 */
@Service("userService")
public class UserService {
    @Autowired
    private UserDao userDao;

    public void sayHello(){
        System.out.println("userservice");
    }

    public void save(){
        userDao.save();
    }
}
