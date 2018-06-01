package com.spring.demo2;

/**
 * Created by admin on 2018/5/22.
 */
public class Baen3Factory {
    public Bean3 getBean3(){
        System.out.println("实例工厂的Bean3实例化了");
        return new Bean3();
    }
}
