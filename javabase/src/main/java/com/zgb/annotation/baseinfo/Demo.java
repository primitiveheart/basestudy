package com.zgb.annotation.baseinfo;

/**
 * Created by admin on 2018/5/17.
 */
public class Demo {
    @MyAnnotation(username = "test", age = 12)
    public void add(String username, int age){
        System.out.println(username + "======" + age);
    }
}
