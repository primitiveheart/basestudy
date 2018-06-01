package com.spring.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by admin on 2018/5/22.
 */
public class ItemServiceTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ItemService itemService1 = (ItemService) applicationContext.getBean("itemService");
        ItemService itemService12 = (ItemService) applicationContext.getBean("itemService");
        System.out.println(itemService1);
        System.out.println(itemService12);
    }
}