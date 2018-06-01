package com.aop.demo1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by admin on 2018/5/24.
 */
public class MyJDKProxyTest {
    @Test
    public void createProxy() throws Exception {
        ProductDao productDao = new ProductDaoImpl();
        ProductDao proxy = new MyJDKProxy(productDao).createProxy();
        proxy.delete();
        proxy.save();
        proxy.query();
        proxy.update();
    }

}