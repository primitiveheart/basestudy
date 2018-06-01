package com.aop.demo5;

import com.aop.demo3.UserDao;
import com.aop.demo4.CustomDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by admin on 2018/5/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext5.xml")
public class BeanNameAutoTest {

    @Resource(name = "customDao")
    private CustomDao customDao;

    @Resource(name = "userDao")
    private UserDao userDao;

    @Test
    public void test(){
        customDao.delete();
        customDao.update();
        customDao.query();
        customDao.save();

        userDao.query();
        userDao.delete();
        userDao.save();
        userDao.update();
    }
}