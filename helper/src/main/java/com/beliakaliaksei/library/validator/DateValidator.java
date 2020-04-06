package com.beliakaliaksei.library.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.sql.Date;

public class DateValidator implements ConstraintValidator<NullOrFullDate, Date> {

    @Override
    public void initialize(NullOrFullDate constraintAnnotation) {

    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        if(date == null) {
            return true;
        } else if(date.toString().equals("")) {
            return true;
        } else if(date.toString().equals("1970-01-01")){
            return false;
        } else{
            return date.toString().matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$");
        }
    }
}
