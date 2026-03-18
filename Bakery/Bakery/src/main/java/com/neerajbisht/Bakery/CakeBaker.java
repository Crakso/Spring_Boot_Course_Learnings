package com.neerajbisht.Bakery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CakeBaker {

//    private Frosting Chocolate_frosting = new Chocolate_Frosting();
//    private Frosting Strawberry_frosting = new Strawberry_Frosting();
//    private Syrup Choco_syrup = new Chocolate_Syrup();
//    private Syrup Strawberry_syrup = new Strawberry_Syrup();

//    @Autowired
    private final Frosting frosting;
//    @Autowired
    private final Syrup syrup;


    CakeBaker(@Qualifier(value = "choco") Frosting frosting,@Qualifier(value = "strawberry") Syrup syrup){
        this.frosting=frosting;
        this.syrup=syrup;
    }

    @GetMapping("/")
    public void bakeCake(){

//        Chocolate_frosting.getFrostingType();
//        Strawberry_frosting.getFrostingType();
//        Choco_syrup.getSyrupType();
//        Strawberry_syrup.getSyrupType();

        frosting.getFrostingType();
        syrup.getSyrupType();

    }
}
