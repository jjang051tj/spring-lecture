package com.jjang051.di.annotation;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderManager {

    @Inject
    @Named("kia")
    private CarMaker maker;

    @Autowired
    public OrderManager(@Qualifier("kia") CarMaker maker) {
        this.maker = maker;
    }
    public void setMaker(CarMaker maker) {
        this.maker = maker;
    }

    public void order() {
        Money money = new Money(30_000_000);
        System.out.println("car agency : (cost) "+money.getAmount());
        System.out.println("car agency : (pay) "+money.getAmount());

        //자동차 인수
        Car car = maker.sell(money);
        System.out.println("car agency : (acquisition) "+car.getName());


    }
}
