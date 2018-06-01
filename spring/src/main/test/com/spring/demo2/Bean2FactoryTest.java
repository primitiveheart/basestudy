package com.spring.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by admin on 2018/5/22.
 */
public class Bean2FactoryTest {
    @Test
    public void getBean2() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");
        System.out.println(bean2);
    }

}