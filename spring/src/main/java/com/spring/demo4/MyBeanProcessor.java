package com.spring.demo4;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * Created by admin on 2018/5/22.
 */
public class MyBeanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第五步;" + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        System.out.println("第八步：" + bean);
        if("producteService".equals(beanName)){
            Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                    System.out.println(System.currentTimeMillis());
                    Object invoke = method.invoke(bean, objects);
                    System.out.println(System.currentTimeMillis());
                    return invoke;
                }
            });
            return proxy;
        }
        return bean;
    }
}
