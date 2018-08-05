package org.helpme.exception.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Size(max = 20, message = "Phone number can not have more than 20 characters")
@Pattern(regexp = "[0-9]+", message = "Phone number can have only numbers")

@Retention(RUNTIME)
@Target({ METHOD, FIELD })
@Constraint(validatedBy = {})
@Documented
public @interface ValidPhoneNumber {
	String message() default "Phone number is not valid!";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}