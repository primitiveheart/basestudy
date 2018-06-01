package com.aop.demo1;

/**
 * Created by admin on 2018/5/24.
 */
public class ProductDaoImpl implements ProductDao {
    @Override
    public void save() {
        System.out.println("保存----------");
    }

    @Override
    public void update() {
        System.out.println("更新----------");
    }

    @Override
    public void delete() {
        System.out.println("删除----------");
    }

    @Override
    public void query() {
        System.out.println("查询----------");
    }
}
