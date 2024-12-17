package com.jjang051.di02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

//scan의 대상이 됨.
// spring container (스프링이 관리하는 여러가지 객체들의 모아놓은 장소)

public class Member {
    private String name;
    private String nickName;
    private Printer printer;

    public Member() {
    }

    public Member(String name, String nickName, Printer printer) {
        this.name = name;
        this.nickName = nickName;
        this.printer = printer;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public void setPrinter(Printer printer) {
        this.printer = printer;
    }
    public void print() {
        printer.print("Hello " + name+" : "+nickName);
    }


}
