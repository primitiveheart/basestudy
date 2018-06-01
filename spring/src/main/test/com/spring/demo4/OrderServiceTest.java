package com.spring.demo4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by admin on 2018/5/22.
 */
public class OrderServiceTest {
    @Test
    public void save() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderService orderService = (OrderService)applicationContext.getBean("orderService");
        orderService.save();
        applicationContext.close();
    }

}