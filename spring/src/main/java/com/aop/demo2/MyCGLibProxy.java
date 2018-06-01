package com.aop.demo2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by admin on 2018/5/24.
 */
public class MyCGLibProxy implements MethodInterceptor{
    private OrderDao orderDao;
    public MyCGLibProxy(OrderDao orderDao){
        this.orderDao = orderDao;
    }

    public OrderDao createProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(orderDao.getClass());
        enhancer.setCallback(this);
        OrderDao proxy = (OrderDao) enhancer.create();
        return proxy;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if("update".equals(method.getName())){
            System.out.println("执行动态代理");
            return  methodProxy.invokeSuper(o, objects);
        }else{
            return  methodProxy.invokeSuper(o, objects);
        }
    }
}
