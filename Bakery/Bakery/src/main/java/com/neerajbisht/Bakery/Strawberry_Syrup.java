package com.neerajbisht.Bakery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier(value = "strawberry")
//@ConditionalOnProperty(name="syrup.choose",havingValue = "strawberry")
public class Strawberry_Syrup implements Syrup{
    @Override
    public void getSyrupType() {
        System.out.println("Strawberry Syrup");
    }
}
