package com.jjang051.di02;

public class PrinterB implements Printer {

    @Override
    public void print(String msg) {
        System.out.println("PrinterB : "+msg);
    }
}
