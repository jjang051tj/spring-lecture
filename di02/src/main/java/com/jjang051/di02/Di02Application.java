package com.jjang051.di02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Di02Application {

    public static void main(String[] args) {

        //SpringApplication.run(Di02Application.class, args);
        ApplicationContext applicationContext = SpringApplication.run(Di02Application.class, args);

        Member member01 = (Member) applicationContext.getBean("member01");
        member01.print();


        Member member02 = applicationContext.getBean("im", Member.class);
        member02.print();

        Member member03 = (Member) applicationContext.getBean("member01");
        member03.print();

        if(member01==member03){
            System.out.println("싱글턴으로 생성된 같은 객체");
        } else {
            System.out.println("다른 객체");
        }
    }

}
