package com.aop.demo4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by admin on 2018/5/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CustomDaoTest {


    @Autowired
    @Qualifier("customDaoProxy")
    private CustomDao customDao;

    @Test
    public void test(){
        customDao.save();
        customDao.query();
        customDao.delete();
        customDao.update();
    }

}