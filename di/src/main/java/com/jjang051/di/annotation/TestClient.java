package com.jjang051.di.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClient {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("car-config-annotation.xml");
        OrderManager orderManager = applicationContext.getBean("orderManager",OrderManager.class);
        //CarMaker carMaker = new SsangyongMaker();  // 아무차나 파는 대리점이 됐음
        //orderManager.setMaker(carMaker);
        System.out.println("orderManager: " + orderManager);
        orderManager.order();
    }
}
