package com.spring.demo5;

/**
 * Created by admin on 2018/5/22.
 */
public class Car {
    private String name;
    private double price;
    public Car(String name, double price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
