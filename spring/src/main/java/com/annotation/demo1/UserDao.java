package com.annotation.demo1;

import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2018/5/23.
 */
@Repository
public class UserDao {
    public void save(){
        System.out.println("保存user");
    }
}
