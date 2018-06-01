package com.spring.demo5;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by admin on 2018/5/22.
 */
public class Car2Test {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car2 c = (Car2)applicationContext.getBean("car2");
        System.out.println(c);
    }
}