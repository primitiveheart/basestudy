package com.aop.demo2;

/**
 * Created by admin on 2018/5/24.
 */
public class OrderDao {
    public void save() {
        System.out.println("保存----------");
    }

    public void update() {
        System.out.println("更新----------");
    }

    public void delete() {
        System.out.println("删除----------");
    }

    public void query() {
        System.out.println("查询----------");
    }
}
