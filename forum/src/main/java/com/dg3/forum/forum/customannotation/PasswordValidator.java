package com.dg3.forum.forum.customannotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordMatch, String>{

//    @Override
//    public void initialize(PasswordMatch p) {
//        
//    }
    
    public boolean isValid(String value, ConstraintValidatorContext context) {
    	
       if (value == null) {
    	   return false;
       }
	return value.matches("^(.*\\b)(?=.*[~!@#$%^&*()]+.*).{8,}$");
       
       }


}	
