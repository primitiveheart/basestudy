package com.aop.demo4;

/**
 * Created by admin on 2018/5/24.
 */
public class CustomDao {
    public void save(){
        System.out.println("保存客户-------------");
    }
    public void update(){
        System.out.println("更新客户-------------");
    }
    public void query(){
        System.out.println("查询客户-------------");
    }
    public void delete(){
        System.out.println("删除客户-------------");
    }
}
