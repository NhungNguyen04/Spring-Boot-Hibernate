package com.nhung.validationdemo.customvalidator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // define default course code
    public String value() default "LUV";

    // define default error message
    public String message() default "Invalid Course Code, must start with LUV";

    // define default groups
    public Class<?>[] groups() default {};

    // define default payloads (payload: provides details about error message)
    public Class<? extends Payload>[] payload() default {};
}
