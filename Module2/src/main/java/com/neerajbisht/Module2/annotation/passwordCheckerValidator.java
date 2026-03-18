package com.neerajbisht.Module2.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class passwordCheckerValidator  implements ConstraintValidator<passwordCheckerValidationAnnotation,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{10,}$");
    }
}


//^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{10,}$

//^: Start of the string.
//(?=.*[a-z]): Lookahead assertion: Ensures there is at least one lowercase letter (a-z).
//(?=.*[A-Z]): Lookahead assertion: Ensures there is at least one uppercase letter (A-Z).
//(?=.*\d): Lookahead assertion: Ensures there is at least one digit (\d is 0-9).
//(?=.*[@$!%*?&]): Lookahead assertion: Ensures there is at least one special character from this specific set: @, $, !, %, *, ?, &.
//[A-Za-z\d@$!%*?&]{10,}: Matches characters that are either letters, digits, or the allowed special characters, and requires a minimum length of 10 or more characters.
//$: End of the string.