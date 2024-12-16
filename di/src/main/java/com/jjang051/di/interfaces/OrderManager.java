package com.jjang051.di.interfaces;

public class OrderManager {
    private CarMaker maker;
    /*
    public OrderManager() {
        //maker = new KiaMaker();
        maker = new HyundaiMaker();
    }
     */

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
