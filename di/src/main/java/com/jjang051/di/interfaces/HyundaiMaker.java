package com.jjang051.di.interfaces;

public class HyundaiMaker implements CarMaker {
    //자동차 만들어서 파는 곳
    public Car sell(Money money) {
        System.out.println("hyundai : (agency collect) "+money.getAmount());
        Car car = new Car("grandeur");
        System.out.println("hyundai : (product) "+car.getName());
        System.out.println("hyundai : (sell) "+car.getName());
        return car;
    }
}
