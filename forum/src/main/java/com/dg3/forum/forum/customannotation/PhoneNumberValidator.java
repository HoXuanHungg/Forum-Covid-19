package com.dg3.forum.forum.customannotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<Phone, String> {

    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
    	
        if (phoneNumber == null ) {
     	   return false;
        }
 	return phoneNumber.matches("^0\\d{9}$");
        
        }
}
