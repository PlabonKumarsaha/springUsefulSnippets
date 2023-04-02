package com.pks.customannotation.annotation;


import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = TestValidator.class)
public @interface ValidateFieldType {

    public String message() default "Invalid Type";

    Class<?>[] groups() default {};
}
