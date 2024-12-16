package com.jjang051.di.annotation;

import org.springframework.stereotype.Component;

@Component("ssangyong")
public class SsangyongMaker implements CarMaker {
    @Override
    public Car sell(Money money) {
        System.out.println("ssangyong : (agency collect) "+money.getAmount());
        Car car = new Car("korando");
        System.out.println("ssangyong : (product) "+car.getName());
        System.out.println("ssangyong : (sell) "+car.getName());
        return car;
    }
}
