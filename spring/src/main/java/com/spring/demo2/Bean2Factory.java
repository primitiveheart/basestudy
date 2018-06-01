package com.spring.demo2;

/**
 * Created by admin on 2018/5/22.
 */
public class Bean2Factory {
    public static Bean2 getBean2(){
        System.out.println("静态工厂的Bean2实例化了");
        return new Bean2();
    }
}
