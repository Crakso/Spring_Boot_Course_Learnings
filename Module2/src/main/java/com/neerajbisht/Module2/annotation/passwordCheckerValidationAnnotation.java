package com.neerajbisht.Module2.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = passwordCheckerValidator.class)
public @interface passwordCheckerValidationAnnotation {
    String message() default "Password should be the combination of upper letter, lower letter, special letter and minimum length of password should be 10.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
