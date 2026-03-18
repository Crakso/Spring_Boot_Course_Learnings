package com.neerajbisht.Bakery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier(value = "choco")
//@ConditionalOnProperty(name = "frosting.choose", havingValue = "choco")
public class Chocolate_Frosting implements Frosting {

    @Override
    public void getFrostingType() {
        System.out.println("Chocolate Frosting.");
    }
}
