package com.jjang051.di.annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface CarMaker {
    public Car sell(Money money);
}
