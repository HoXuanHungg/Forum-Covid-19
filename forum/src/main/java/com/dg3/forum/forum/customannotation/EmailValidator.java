package com.dg3.forum.forum.customannotation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {
    private String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.isEmpty())
            return false;

        Pattern pat = Pattern.compile(regex);
        return pat.matcher(email).matches();
    }

}
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//import java.util.regex.Pattern;
//public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
//    private String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//
//    @Override
//    public boolean isValid(String email, ConstraintValidatorContext context) {
//        if (email == null || email.isEmpty())
//            return true;
//
//        Pattern pat = Pattern.compile(regex);
//        return pat.matcher(email).matches();
//    }
//
//}
