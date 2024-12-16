package com.jjang051.di.interfaces;

public class TestClient {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        CarMaker carMaker = new SsangyongMaker();  // 아무차나 파는 대리점이 됐음
        orderManager.setMaker(carMaker);
        orderManager.order();
    }
}
