package com.jjang051.di02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Member member01() {
        Member member01 = new Member();
        member01.setName("홍길동");
        member01.setNickName("불효자");
        member01.setPrinter(new PrinterA());
        return member01;
    }
    @Bean(name="im")
    public Member member02() {
        return new Member("임꺽정","도적", new PrinterA());
    }
}
