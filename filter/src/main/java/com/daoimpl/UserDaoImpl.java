package com.daoimpl;

import com.dao.UserDao;
import com.util.C3P0Utils;
import com.vo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by admin on 2018/5/17.
 */
public class UserDaoImpl implements UserDao {
    private QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
    @Override
    public User find(String username, String password) {
        try {
            return queryRunner.query("select * from user where username=? and password=?", new BeanHandler<User>(User.class), username, password);
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }
}
