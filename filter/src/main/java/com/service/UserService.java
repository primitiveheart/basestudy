package com.service;

import com.vo.User;

/**
 * Created by admin on 2018/5/17.
 */
public interface UserService {
    User login(String name, String password);
}
