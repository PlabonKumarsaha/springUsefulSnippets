package com.pks.customannotation.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class TestValidator implements ConstraintValidator<ValidateFieldType,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        List<String> testType = Arrays.asList("A","B");
        return testType.contains(s);
    }
}
