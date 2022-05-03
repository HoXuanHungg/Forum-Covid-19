package com.dg3.forum.forum.customannotation;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy=PasswordValidator.class)
@Documented
public @interface PasswordMatch {
    String message() default "Entry password invalid, Try again! (At least one uppercase, lowercase, number, and special character, at least 8 in length)";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}

