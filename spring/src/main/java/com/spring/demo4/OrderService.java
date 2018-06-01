package com.spring.demo4;

/**
 * Created by admin on 2018/5/22.
 */
public class OrderService {
    public void init(){
        System.out.println("该实例初始化");
    }

    public void save(){
        System.out.println("保存订单");
    }

    public void destroy(){
        System.out.println("该实例销毁了");
    }
}
