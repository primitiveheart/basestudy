package com.aop.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by admin on 2018/5/24.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoTest {

    @Autowired
    @Qualifier("userDaoProxy")
    private UserDao userDao;

    @Test
    public void test(){
        userDao.update();
        userDao.save();
        userDao.delete();
        userDao.query();
    }
}