package com.dg3.forum.forum.customannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE })
@Constraint(validatedBy = EmailValidator.class)
public @interface Email {
    String message() default "You have entered an invalid e-mail address. Please try again!";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
