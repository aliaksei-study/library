package com.beliakaliaksei.library.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NullOrFullDate {
    String message() default "{Date}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
