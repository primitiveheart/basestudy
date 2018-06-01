package com.aop.demo2;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by admin on 2018/5/24.
 */
public class MyCGLibProxyTest {
    @Test
    public void createProxy() throws Exception {
        OrderDao orderDao = new OrderDao();
        OrderDao proxy = new MyCGLibProxy(orderDao).createProxy();
        proxy.save();
        proxy.query();
        proxy.delete();
        proxy.update();
    }

}