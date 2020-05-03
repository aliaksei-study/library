package com.beliakaliaksei.library.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.File;

public class ImageValidator implements ConstraintValidator<Image, File> {

    @Override
    public void initialize(Image constraintAnnotation) {

    }

    @Override
    public boolean isValid(File file, ConstraintValidatorContext constraintValidatorContext) {
        if(file == null) {
            return true;
        } else {
            return (file.getName().endsWith("jpeg") || file.getName().endsWith("jpg") || file.getName().endsWith("png"));
        }
    }
}
