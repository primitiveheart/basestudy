package com.aop.demo7;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by admin on 2018/5/24.
 */
public class JDBCTest {
    public static void main(String[] args){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/basestudy");
        driverManagerDataSource.setPassword("root");
        driverManagerDataSource.setUsername("root");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
        jdbcTemplate.execute("CREATE TABLE temp(id int ,name VARCHAR(10))");
    }
}
