package com.neerajbisht.Bakery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier(value = "strawberry")
//@ConditionalOnProperty(name = "frosting.choose", havingValue = "strawberry")
public class Strawberry_Frosting implements Frosting {
    @Override
    public void getFrostingType() {
        System.out.println("Strawberry Frosting.");
    }
}

