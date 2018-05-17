package com.dao;

import com.vo.User;

/**
 * Created by admin on 2018/5/17.
 */
public interface UserDao {
    User find(String username, String password);
}
