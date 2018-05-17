package com.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by admin on 2018/5/17.
 */
public class C3P0Utils {
    public static DataSource getDataSource(){
        ComboPooledDataSource dataSource = null;
        try {
//            Properties properties = new Properties();
//            InputStream in = C3P0Utils.class.getClassLoader().getResourceAsStream("db.properties");
//            properties.load(in);
            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/basestudy");
            dataSource.setUser("root");
            dataSource.setPassword("root");
//            dataSource.setDriverClass(properties.getProperty("driverClassName"));
//            dataSource.setJdbcUrl(properties.getProperty("url"));
//            dataSource.setUser(properties.getProperty("username"));
//            dataSource.setPassword(properties.getProperty("password"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataSource;
    }
    public static void main(String[] args){
        getDataSource();
    }
}
