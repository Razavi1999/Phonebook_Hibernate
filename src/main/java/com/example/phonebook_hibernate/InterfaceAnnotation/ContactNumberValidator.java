package com.example.phonebook_hibernate.InterfaceAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements ConstraintValidator<ContactNumberConstraint , String> {
    @Override
    public void initialize(ContactNumberConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext ctx) {
        return phone != null &&
                phone.matches("[0-9]+") &&
                phone.length() > 8 &&
                phone.length() < 14
                ;
    }
}
