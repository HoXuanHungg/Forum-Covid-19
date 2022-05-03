package com.dg3.forum.forum.customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {

	String message() default "Invalid phone number format! (Ex:0xxxxxxxxx)";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
