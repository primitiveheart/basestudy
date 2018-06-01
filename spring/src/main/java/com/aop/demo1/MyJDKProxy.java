package com.aop.demo1;

import com.annotation.demo2.Product;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * Created by admin on 2018/5/24.
 */
public class MyJDKProxy implements InvocationHandler{
    private ProductDao productDao;

   public MyJDKProxy(ProductDao productDao){
       this.productDao = productDao;
   }

   public ProductDao createProxy(){
       ProductDao proxy = (ProductDao) Proxy.newProxyInstance(productDao.getClass().getClassLoader(), productDao.getClass().getInterfaces(), this);
       return proxy;
   }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        if("delete".equals(method.getName())){
            System.out.println("进行代理------");
            return method.invoke(productDao, objects);
        }else {
          return  method.invoke(productDao, objects);
        }
    }
}
