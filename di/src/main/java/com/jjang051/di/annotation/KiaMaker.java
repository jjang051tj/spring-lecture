package com.jjang051.di.annotation;

import org.springframework.stereotype.Component;

@Component("kia")
public class KiaMaker implements CarMaker {
    public Car sell(Money money) {
        System.out.println("kia : (agency collect) "+money.getAmount());
        Car car = new Car("K8");
        System.out.println("kia : (product) "+car.getName());
        System.out.println("kia : (sell) "+car.getName());
        return car;
    }
}
