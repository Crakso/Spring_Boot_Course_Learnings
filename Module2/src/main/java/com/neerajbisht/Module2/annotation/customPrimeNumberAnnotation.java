package com.neerajbisht.Module2.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = primeNumberValidator.class)
public @interface customPrimeNumberAnnotation {
   String message() default "Number should be a prime number.";

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};
}
