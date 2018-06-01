package com.spring.demo4;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import java.beans.PropertyDescriptor;
import java.util.Properties;

/**
 * Created by admin on 2018/5/22.
 */
public class ProductServiceImpl implements ProductService, BeanNameAware, BeanFactoryAware, InitializingBean,DisposableBean{
    private String name;

    public ProductServiceImpl(){
        System.out.println("第一步：实例化");
    }

    public void setName(String name) {
        System.out.println("第二步：设置属性 " + name);
        this.name = name;
    }

    public void init(){
        System.out.println("第七步：初始化");
    }

    public void save(){
        System.out.println("保存商品");
    }

    public void find(){
        System.out.println("查询商品");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("第三步：让bean了解bean" + s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("第四步：" + beanFactory);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第六步：属性设置完成");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("第十步：由spring进行销毁");
    }

    public void teardown(){
        System.out.println("第十一步");
    }

}
