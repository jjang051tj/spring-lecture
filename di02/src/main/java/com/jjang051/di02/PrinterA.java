package com.jjang051.di02;

public class PrinterA implements Printer {

    @Override
    public void print(String msg) {
        System.out.println("PrinterA : "+msg);
    }
}
