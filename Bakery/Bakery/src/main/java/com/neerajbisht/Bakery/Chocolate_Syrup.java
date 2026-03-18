package com.neerajbisht.Bakery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier(value = "choco")
//@ConditionalOnProperty(name = "syrup.choose", havingValue = "choco")
public class Chocolate_Syrup implements Syrup{
    @Override
    public void getSyrupType() {
        System.out.println("Chocolate Syrup.");
    }
}
