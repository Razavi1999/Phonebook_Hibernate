package com.example.testMaven.InterfaceAnnotation;

import com.example.testMaven.entity.Contact;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
@Documented
@Target({ElementType.METHOD , ElementType.FIELD})
@Constraint(validatedBy = ContactNumberValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactNumberConstraint {
    String message() default "Invalid phone number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
