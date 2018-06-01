package com.annotation.demo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.regex.Pattern;

/**
 * Created by admin on 2018/5/23.
 */
@Configuration
public class BeanConfig {
    @Bean("car")
    public Car carInfo(){
        Car car = new Car();
        car.setName("sdfsdf");
        car.setPrice(11111111.0);
        return car;
    }

    @Bean("product")
    public Product createProduct(){
        Product product = new Product();
        product.setName("sdfsgfsf");
        product.setPrice(1231313.3);
        return product;
    }
}
