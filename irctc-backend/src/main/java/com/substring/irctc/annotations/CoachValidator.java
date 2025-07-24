package com.substring.irctc.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Valid;

public class CoachValidator implements ConstraintValidator<ValidCoach, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        System.out.println("Test");

        if(value>100){
            return true;
        }
        //logic for validation
        return false;
    }
}
