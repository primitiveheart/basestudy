package com.aop.demo6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * Created by admin on 2018/5/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext7.xml")
public class ItemDaoTest {

    @Resource(name = "itemDao")
    private ItemDao itemDao;

    @Test
    public void test() throws Exception {
        itemDao.update();
        itemDao.save();
        itemDao.delete();
        itemDao.query();
    }

}