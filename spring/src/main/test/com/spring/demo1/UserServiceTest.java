package com.spring.demo1;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


/**
 * Created by admin on 2018/5/22.
 */
public class UserServiceTest {
    @Test
    public void sayHello() throws Exception {
//        方式一:
//        UserService userService = new UserServiceImpl();
//        userService.sayHello();
        //方式二:
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService userService = (UserService) ac.getBean("userService");
//        userService.sayHello();
//        方式三：
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        UserService userService = (UserService) factory.getBean("userService");
        userService.sayHello();
    }

}