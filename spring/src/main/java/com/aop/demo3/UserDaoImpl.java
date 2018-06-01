package com.aop.demo3;

/**
 * Created by admin on 2018/5/24.
 */
public class UserDaoImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("保存用户--------------");
    }

    @Override
    public void delete() {
        System.out.println("删除用户--------------");
    }

    @Override
    public void query() {
        System.out.println("查询用户--------------");
    }

    @Override
    public void update() {
        System.out.println("更新用户--------------");
    }
}
