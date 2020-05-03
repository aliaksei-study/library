package com.beliakaliaksei.library.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ImageValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Image {
    String message() default "{Image}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
