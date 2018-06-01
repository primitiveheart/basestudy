package com.aop.demo6;

/**
 * Created by admin on 2018/5/24.
 */
public class ItemDaoImpl implements ItemDao {
    @Override
    public void save() {
        System.out.println("'保存项目=============");
    }

    @Override
    public void update() {
        System.out.println("'更新项目=============");
    }

    @Override
    public void query() {
        System.out.println("'查询项目=============");
    }

    @Override
    public void delete() {
        System.out.println("'删除项目=============");
    }
}
