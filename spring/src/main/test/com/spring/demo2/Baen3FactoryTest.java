package com.spring.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by admin on 2018/5/22.
 */
public class Baen3FactoryTest {
    @Test
    public void getBean3() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean3 bean3 = (Bean3) applicationContext.getBean("bean3");
        System.out.println(bean3);
    }

}