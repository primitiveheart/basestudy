package com.spring.demo4;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by admin on 2018/5/22.
 */
public class ProductServiceTest {
    @Test
    public void find() throws Exception {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService productService = (ProductService) classPathXmlApplicationContext.getBean("productService");
        productService.save();
        productService.find();
        classPathXmlApplicationContext.close();
    }

}