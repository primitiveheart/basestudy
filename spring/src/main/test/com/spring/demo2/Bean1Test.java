package com.spring.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by admin on 2018/5/22.
 */
public class Bean1Test {
    @Test
    public void demo2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
        System.out.println(bean1);
    }
}