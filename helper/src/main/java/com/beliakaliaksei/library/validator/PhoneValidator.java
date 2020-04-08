package com.beliakaliaksei.library.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<CellPhone, String> {

    @Override
    public void initialize(CellPhone constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null) {
            return true;
        } else if (s.equals("")) {
            return true;
        } else if (s.matches("\\d{9}")){
            return true;
        } else if(s.matches("\\d{2}[-\\.\\s]\\d{3}[-\\.\\s]\\d{2}[-\\.\\s]\\d{2}")) {
            return true;
        } else if(s.matches("\\(\\d{2}\\)\\d{3}\\d{2}\\d{2}")) {
            return true;
        } else {
            return s.matches("\\(\\d{3}\\)\\d{2}\\d{3}\\d{4}");
        }
    }
}
