package com.beliakaliaksei.library.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CharacterValidator implements ConstraintValidator<Character, String> {
    @Override
    public void initialize(Character constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null) {
            return true;
        } else if(s.equals("")) {
            return true;
        } else {
            return s.matches("^[A-Z][a-z]+( [A-Z][a-z]+)*$");
        }
    }
}
