package com.neerajbisht.Module2.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class primeNumberValidator implements ConstraintValidator<customPrimeNumberAnnotation,Integer>{

    @Override
    public boolean isValid(Integer number, ConstraintValidatorContext constraintValidatorContext) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
