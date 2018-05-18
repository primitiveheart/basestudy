package com.util;

import com.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/5/18.
 */
public class UserDB {
    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("admin","123"));
        userList.add(new User("test","test"));
    }

    public static User find(String username ,String password){
        for(User u : userList){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

}
