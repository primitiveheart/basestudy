package com.annotation.demo2;

import org.junit.Test;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by admin on 2018/5/23.
 */
public class BeanConfigTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car car = (Car)applicationContext.getBean("car");
        Product product = (Product)applicationContext.getBean("product");
        System.out.println(car);
        System.out.println(product);
    }
}